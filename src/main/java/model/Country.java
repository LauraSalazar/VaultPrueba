package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "COUNTRIES")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
	private Integer id;
	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Region region;

	public Country() {
	super();	
	}
	
	public Country(String countryName, Region region) {
		super();
		this.countryName = countryName;
		this.region = region;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
