package org.jhveras.samples.oraclehr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "LOCATIONS")
public class Location {

	@Id
	@SequenceGenerator(
	        name="LOCATION_SEQUENCE_GENERATOR",
	        sequenceName="LOCATIONS_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LOCATION_SEQUENCE_GENERATOR")
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country countryId) {
		this.country = countryId;
	}
}
