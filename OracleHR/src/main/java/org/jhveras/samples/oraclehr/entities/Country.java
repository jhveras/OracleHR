package org.jhveras.samples.oraclehr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Countries")
public class Country {

	@Id
	private String countryId;

	private String countryName;

	@ManyToOne(optional = false)
	@JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
	private Region regionId;

	public Country() {

	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegionId() {
		return regionId;
	}

	public void setRegionId(Region region) {
		this.regionId = region;
	}

}
