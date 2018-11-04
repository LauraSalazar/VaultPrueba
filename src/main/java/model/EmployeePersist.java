package model;

import java.time.LocalDate;
import java.util.List;

public class EmployeePersist extends Employee{
	public EmployeePersist(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job,
			Double salary, Double commissionPct, Department department,List<JobHistory> jobHistory) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.department = department;
	}
}
