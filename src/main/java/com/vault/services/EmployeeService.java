package com.vault.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.vault.dto.EmployeeDTO;

import dbaccess.vault.EmployeeDAO;
import model.Employee;

@Service
public class EmployeeService {

	EmployeeDAO empDAO = new EmployeeDAO();
			
	public EmployeeDTO insertarEmpleado(String firstName,String lastName,String email,String phoneNumber,String hireDate,String salary,String commissionPct) {
		
		Employee emp = new Employee(firstName,lastName,email,phoneNumber,LocalDate.parse(hireDate),null,new Double(salary),new Double(commissionPct),null,null);
		
		empDAO.create(emp);
		
		return new EmployeeDTO(emp);
	}
}
