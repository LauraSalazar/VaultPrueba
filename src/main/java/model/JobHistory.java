package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "JOB_HISTORY")
public class JobHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JOBHISTORY_ID")
	private Integer id;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Employee employee;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Job job;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Department department;
	
	public JobHistory() {
		super();
	}
	
	public JobHistory(Employee employee, Date startDate, Date endDate, Job job, Department department) {
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
