package com.vault.services;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dbaccess.vault.DepartmentDAO;
import dbaccess.vault.LocationDAO;
import model.Department;
import model.Location;

@Service
public class DepartmentService {

	DepartmentDAO deptDAO = new DepartmentDAO();
	LocationDAO locDAO = new LocationDAO();

	@Transactional
	public String insert(String departmentName, Integer locationId) {

		// Department dept = new Department(departmentName,null,locationId);
		Double promedio = deptDAO.calcularPromedio(locationId);
		String message = null;
		Calendar c2 = new GregorianCalendar();
		Integer dia = c2.get(Calendar.DATE);
		if (promedio > 1000) {

			dia = c2.get(Calendar.DATE);
			if (dia < 15) {
				System.out.println(dia);
				Location location = locDAO.findById(locationId);
				if (location != null) {
					Department d = new Department();
					d.setDepartmentName(departmentName);
					d.setManager(null);
					d.setLocation(location);
					deptDAO.getEntityManager().merge(location);
					deptDAO.create(d);
					message = "Se agrego el department porque estamos antes del 15 y el promedio es mayor que 1000";
				} else {
					message = "No existe la location";
				}
			}
			else {
				message = "El promedio es > 1000 pero estamos antes del 15";
			}
		}else {
		message = "El promedio es < 1000 y estamos antes del 15";
		}
		if (dia > 15) {
			if (promedio > 1500) {

				message = "el monto promedio es mayor a 1500 y estamos despues del 15";
			} else {
				System.out.println(dia);
				Location location = locDAO.findById(locationId);
				deptDAO.create(new Department(departmentName, null, location));
				message = "Se agrego el department porque estamos despues del 15 y el monto es menor o igual a 1500";
			}
		}
		return message;
	}
}
