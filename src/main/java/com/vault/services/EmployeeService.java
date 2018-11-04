package com.vault.services;

import java.time.LocalDate;

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

	public String modificarEmpleado(Integer id, String firstName, String lastName, String email,
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
		}
		else {
			return "No existe el Empleado";
		}
		return "Se ha modificado el empleado";
	}
	
	public String eliminarEmpleado(Integer id) {

		Employee emp = null;

		emp = empDAO.findById(id);

		if (emp != null) {
			empDAO.delete(emp);
		}
		else {
			return "No existe el Empleado";
		}
		return "Se ha eliminado el empleado";
	}
}
