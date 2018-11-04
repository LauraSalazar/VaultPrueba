package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "EMPLOYEES")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private Integer id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "HIRE_DATE")
	private LocalDate hireDate;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "JOB_ID")
	private Job job;
	@Column(name = "SALARY")
	private Double salary;
	@Column(name = "COMMISSION_PCT")
	private Double commissionPct;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID")
    private Employee manager;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job,
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
	public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job,
			Double salary, Double commissionPct, Department department) {
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
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
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
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
}
