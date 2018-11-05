package com.vault.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

import dbaccess.vault.DepartmentDAO;


@Service
public class DepartmentService {
	
	DepartmentDAO deptDAO = new DepartmentDAO();
	
	public String insert(String departmentName,Integer locationId) {

		
		//Department dept = new Department(departmentName,null,locationId);
		Double promedio = deptDAO.calcularPromedio(locationId);

		if (promedio > 1000) {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = new GregorianCalendar();
			Integer dia = c2.get(Calendar.DATE);
            System.out.println(dia);
		    
		}
		return departmentName;


	}


}
