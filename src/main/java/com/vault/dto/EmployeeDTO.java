package com.vault.dto;

import java.time.LocalDate;

import com.google.gson.annotations.Expose;

import model.Employee;



public class EmployeeDTO {
	@Expose
	private String firstName;
	@Expose
	private String lastName;
	@Expose
	private String email;
	@Expose
	private String phoneNumber;
	@Expose
	private LocalDate hireDate;
	@Expose
	private Double salary;
	@Expose
	private Double commissionPct;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public EmployeeDTO(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate,
			Double salary, Double commissionPct) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
	}

	public EmployeeDTO(Employee emp) {
		super();
		this.firstName = emp.getFirstName();
		this.lastName = emp.getLastName();
		this.email = emp.getEmail();
		this.phoneNumber = emp.getPhoneNumber();
		this.hireDate = emp.getHireDate();
		this.salary = emp.getSalary();
		this.commissionPct = emp.getCommissionPct();
	}
}
