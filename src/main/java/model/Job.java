package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "JOBS")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JOB_ID")
	private Integer id;
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	@Column(name = "MIN_SALARY")
	private Integer minSalary;
	@Column(name = "MAX_SALARY")
	private Integer maxSalary;
	
	public Job() {
		super();
	}
	
	public Job(String jobTitle, Integer minSalary, Integer maxSalary) {
		super();
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Integer getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}
	public Integer getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	
}
