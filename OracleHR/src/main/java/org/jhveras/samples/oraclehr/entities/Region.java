package org.jhveras.samples.oraclehr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "REGIONS")
public class Region {

	@Id
	@Column(name = "REGION_ID")
	private long regionId;
	
	private String regionName;

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
}
