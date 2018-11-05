package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity(name = "REGIONS")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REGION_ID")
	@Expose
	private Integer id;
	@Column(name = "NAME")
    @Expose
	private String name;
	
	
	public Region() {
		super();
	}
	
	public Region(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
