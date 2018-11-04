package com.vault.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vault.dto.EmployeeDTO;

import dbaccess.vault.EmployeeDAO;
import model.Employee;

@Service
public class EmployeeService {

	EmployeeDAO empDAO = new EmployeeDAO();

	public EmployeeDTO insertarEmpleado(String firstName, String lastName, String email, String phoneNumber,
			String hireDate, String salary, String commissionPct) {

		Employee emp = new Employee(firstName, lastName, email, phoneNumber, LocalDate.parse(hireDate), null,
				new Double(salary), new Double(commissionPct), null, null);

		empDAO.create(emp);

		return new EmployeeDTO(emp);
	}

	public EmployeeDTO modificarEmpleado(Integer id, String firstName, String lastName, String email,
			String phoneNumber, String hireDate, String salary, String commissionPct) {

		Employee emp = null;

		emp = empDAO.findById(id);

		if (emp != null) {
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setEmail(email);
			emp.setPhoneNumber(phoneNumber);
			emp.setHireDate(LocalDate.parse(hireDate));
			emp.setSalary(new Double(salary));
			emp.setCommissionPct(new Double(commissionPct));
			empDAO.update(emp);
			return new EmployeeDTO(emp);
		}
		return null;
	}
	
	public Employee eliminarEmpleado(Integer id) {

		Employee emp = null;

		emp = empDAO.findById(id);

		if (emp != null) {
			empDAO.delete(emp);
		    return emp;
		}
		return null;
		
	}
	
	public EmployeeDTO obtenerEmpleado(Integer id) {

		Employee emp = null;
		EmployeeDTO empDTO = null; 
		emp = empDAO.findById(id);

		if (emp != null) {
			empDTO = new EmployeeDTO(emp);
		}
		return empDTO;
	}
	
	public List<Employee> getEmpleadosByJobId(Integer paginacion,Integer id, Integer pagina){
		return empDAO.getEmpleadosByJobId(id);
		
	}
	
	public List<Employee> getEmpleadosByManagerId(Integer paginacion,Integer id, Integer pagina){
		return empDAO.getEmpleadosByManagerId(id);
	}
	
	public List<Employee> getEmpleadosLastName(Integer paginacion,Integer id, Integer pagina){
		return empDAO.getEmpleadosByManagerId(id);
	}
}
