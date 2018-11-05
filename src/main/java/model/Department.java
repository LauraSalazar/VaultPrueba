package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Entity(name = "DEPARTMENTS")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_ID")
	@Expose
	private Integer id;
	@Column(name = "DEPARTMENT_NAME")
	@Expose
	private String departmentName;
	
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID")
    private Employee manager;
	
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID")
	@Expose
	private Location location;

	public Department() {
		super();
	}
	public Department(String departmentName, Employee manager, Location location) {
		super();
		this.departmentName = departmentName;
		this.manager = manager;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
