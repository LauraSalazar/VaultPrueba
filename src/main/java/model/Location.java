package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "LOCATIONS")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOCATION_ID")
	private Integer id;
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE_PROVINCE")
	private String stateProvince;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Country country;

	
	public Location() {
		super();
	}

	public Location(String streetAddress, String postalCode, String city, String stateProvince, Country country) {
		super();
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


}
