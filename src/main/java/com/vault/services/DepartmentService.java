package com.vault.services;

import org.springframework.stereotype.Service;

import dbaccess.vault.DepartmentDAO;


@Service
public class DepartmentService {
	
	DepartmentDAO deptDAO = new DepartmentDAO();
	
	public String insert(String departmentName,Integer locationId) {

		
		//Department dept = new Department(departmentName,null,locationId);
		Double promedio = deptDAO.calcularPromedio(locationId);

		return departmentName;


	}


}
