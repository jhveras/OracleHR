package org.jhveras.samples.oraclehr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "DEPARTMENTS")
public class Department {

	@Id
	private long departmentId;
	
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;
	
	@ManyToOne
	@JoinColumn(name = "LOCATION_ID")
	private Location locationId;
	
	public Department() {
		
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
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

	public void setManager(Employee managerId) {
		this.manager = managerId;
	}

	public Location getLocationId() {
		return locationId;
	}

	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}
}
