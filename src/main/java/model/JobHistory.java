package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.google.gson.annotations.Expose;

@Entity
@Table(name="JOB_HISTORY")
public class JobHistory implements Serializable{

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;
	@Id
	@Column(name = "START_DATE")
	@Expose
	private LocalDate startDate;
	@Column(name = "END_DATE")
	@Expose
	private LocalDate endDate;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "JOB_ID")
	@Expose
	private Job job;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	public JobHistory() {
		super();
	}
	
	public JobHistory(Employee employee, LocalDate startDate, LocalDate endDate, Job job, Department department) {
		super();
		this.employee = employee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.job = job;
		this.department = department;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
