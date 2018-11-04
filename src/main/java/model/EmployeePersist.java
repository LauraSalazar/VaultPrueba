package model;

import java.time.LocalDate;

public class EmployeePersist extends Employee{
	public EmployeePersist(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job,
			Double salary, Double commissionPct, Employee manager, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.manager = manager;
		this.department = department;
	}
}
