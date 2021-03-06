package model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity(name = "EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	@Expose
	private Integer id;
	@Column(name = "FIRST_NAME")
	@Expose
	private String firstName;
	@Column(name = "LAST_NAME")
	@Expose
	private String lastName;
	@Column(name = "EMAIL")
	@Expose
	private String email;
	@Column(name = "PHONE_NUMBER")
	@Expose
	private String phoneNumber;
	@Column(name = "HIRE_DATE")
	@Expose
	private LocalDate hireDate;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "JOB_ID")
	@Expose
	private Job job;
	@Column(name = "SALARY")
	@Expose
	private Double salary;
	@Column(name = "COMMISSION_PCT")
	@Expose
	private Double commissionPct;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID")
	@Expose
	private Employee manager;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_ID")
	@Expose
	private Department department;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Column(nullable = true)
	@Expose
	private List<JobHistory> jobHistories;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job,
			Double salary, Double commissionPct, Employee manager, Department department, List<JobHistory> jobHistories) {
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
		this.jobHistories = jobHistories;
	}

	public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job,
			Double salary, Double commissionPct, Department department, Collection jobHistories) {
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
		this.jobHistories = (List<JobHistory>) jobHistories;
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
	
	public void addJobHistory(JobHistory jh){
		this.jobHistories.add(jh);
	}

	public List<JobHistory> getJobHistories() {
		return jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

}
