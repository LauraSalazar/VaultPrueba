package com.vault.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/insertarEmpleado/{firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}")
	public String insertar(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("hireDate") String hireDate, @RequestParam("salary") String salary,
			@RequestParam("commissionPct") String commissionPct) {

		EmployeeDTO empDTO = empleadoService.insertarEmpleado(firstName,lastName,email,phoneNumber,hireDate,salary,commissionPct);

		return generateJson(empDTO);
	}
	
	  public String generateJson(Object aSerializableObject) {
	      Map<String,Object> aMap = new HashMap<String,Object>();
	      aMap.put("result", "OK");
	      aMap.put("resultingObjects", aSerializableObject);
	      return new Gson().toJson(aMap);
	  }
}
