package org.jhveras.samples.oraclehr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "LOCATIONS")
public class Location {

	@Id
	private long locationId;
	
	private String streetAddress;
	
	private String postalCode;
	
	private String city;
	
	private String stateProvince;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
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

	public Country getCountryId() {
		return country;
	}

	public void setCountryId(Country countryId) {
		this.country = countryId;
	}
}
