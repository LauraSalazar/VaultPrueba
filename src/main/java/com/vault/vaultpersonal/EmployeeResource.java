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

	// Inserta un empleado con los parametros
	// {firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}"
	@RequestMapping(value = "/insertarEmpleado/{firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}", produces = "application/json")
	public String insertar(Map<String, Object> model, @PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName, @PathVariable("email") String email,
			@PathVariable("phoneNumber") String phoneNumber, @PathVariable("hireDate") String hireDate,
			@PathVariable("salary") String salary, @PathVariable("commissionPct") String commissionPct) {

		EmployeeDTO empDTO = empleadoService.insertarEmpleado(firstName, lastName, email, phoneNumber, hireDate, salary,
				commissionPct);

		return generateJson(empDTO);
	}

	// Modifica un empleado con los parametros
	// {id}/{firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}"
	@RequestMapping(value = "/modificarEmpleado/{id}/{firstName}/{lastName}/{email}/{phoneNumber}/{hireDate}/{salary}/{commissionPct}", produces = "application/json")
	public String modificar(Map<String, Object> model, @PathVariable("id") Integer id,
			@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName,
			@PathVariable("email") String email, @PathVariable("phoneNumber") String phoneNumber,
			@PathVariable("hireDate") String hireDate, @PathVariable("salary") String salary,
			@PathVariable("commissionPct") String commissionPct) {

		EmployeeDTO empDTO = empleadoService.modificarEmpleado(id, firstName, lastName, email, phoneNumber, hireDate,
				salary, commissionPct);
		if (empDTO == null)
		{
			return "No existe el Empleado";
		}
		return "Se ha modificado el empleado";

	}

	// Elimina el empleado con id {id}
	@RequestMapping(value = "/eliminarEmpleado/{id}", produces = "application/json")
	public String eliminar(Map<String, Object> model, @PathVariable("id") Integer id) {

	if (empleadoService.obtenerEmpleado(id)	== null) {
		return "No existe el Empleado";
	}
		empleadoService.eliminarEmpleado(id);
		return "Se ha eliminado el empleado";
	}
	
	// Retorna el empleado con id {id}
	@RequestMapping(value = "/obtenerEmpleado/{id}", produces = "application/json")
	public String obtener(Map<String, Object> model, @PathVariable("id") Integer id) {

		EmployeeDTO empDTO = null;
		empDTO = empleadoService.obtenerEmpleado(id);
		if (empDTO == null) {
			return ("El empleado no existe");
		}
		return generateJson(empDTO);
	}

	// Retorna el una lista de empleados con sus objetos ordenados y paginados
	@RequestMapping(value = "/obtenerListadoEmpleados/{tipofiltro}/{id}/{paginacion}/{pagina}", produces = "application/json")
	public String obtenerListadoEmpleados(Map<String, Object> model, @PathVariable("tipofiltro") String tipoFiltro,@PathVariable("id") Integer id,@PathVariable("paginacion") Integer paginacion,@PathVariable("pagina") Integer pagina) {

		String resultado = null;
		switch (tipoFiltro) {
		case "JOBID" : resultado = generateJson(empleadoService.getEmpleadosByJobId(paginacion,id,pagina));
		break;
	    case "MANAGERID":  resultado = generateJson(empleadoService.getEmpleadosByManagerId(paginacion,id,pagina));
        break;
	    case "LASTNAME": resultado = generateJson(empleadoService.getEmpleadosLastName(paginacion,id,pagina));
        break;
		}
		return resultado;
		
		
	}
	
	public String generateJson(Object aSerializableObject) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("resultingObjects", aSerializableObject);
		return new Gson().toJson(aMap);
	}
}
