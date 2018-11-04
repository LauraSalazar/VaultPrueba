package com.vault.vaultpersonal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vault.dto.EmployeeDTO;
import com.vault.services.EmployeeService;

@RestController
public class EmployeeResource {

	EmployeeService empleadoService;

	public EmployeeResource() {
		super();
		empleadoService = new EmployeeService();
	}

	//Inserta un empleado con los parametros {firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}"
	@RequestMapping(value="/insertarEmpleado/{firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}",produces = "application/json")
	public String insertar(Map<String, Object> model,@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName,
			@PathVariable("email") String email, @PathVariable("phoneNumber") String phoneNumber,
			@PathVariable("hireDate") String hireDate, @PathVariable("salary") String salary,
			@PathVariable("commissionPct") String commissionPct) {

		EmployeeDTO empDTO = empleadoService.insertarEmpleado(firstName,lastName,email,phoneNumber,hireDate,salary,commissionPct);

		return generateJson(empDTO);
	}
	
	//Modifica un empleado con los parametros {id}/{firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}"
	@RequestMapping(value="/modificarEmpleado/{id}/{firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}",produces = "application/json")
	public String modificar(Map<String, Object> model,@PathVariable("id") Integer id,@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName,
			@PathVariable("email") String email, @PathVariable("phoneNumber") String phoneNumber,
			@PathVariable("hireDate") String hireDate, @PathVariable("salary") String salary,
			@PathVariable("commissionPct") String commissionPct) {

		return generateJson(empleadoService.modificarEmpleado(id,firstName,lastName,email,phoneNumber,hireDate,salary,commissionPct));
	}
	
	//Elimina el empleado con id {id}
	@RequestMapping(value="/eliminarEmpleado/{id}",produces = "application/json")
	public String eliminar(Map<String, Object> model,@PathVariable("id") Integer id) {

		return generateJson(empleadoService.eliminarEmpleado(id));
	}
	  public String generateJson(Object aSerializableObject) {
	      Map<String,Object> aMap = new HashMap<String,Object>();
	      aMap.put("result", "OK");
	      aMap.put("resultingObjects", aSerializableObject);
	      return new Gson().toJson(aMap);
	  }
}
