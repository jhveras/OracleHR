package org.jhveras.samples.oraclehr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "DEPARTMENTS")
public class Department {
	
	@Id
	@SequenceGenerator(
	        name="DEPARTMENT_SEQUENCE_GENERATOR",
	        sequenceName="DEPARTMENTS_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPARTMENT_SEQUENCE_GENERATOR")
	private long departmentId;
	
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	@JsonBackReference
	private Employee manager;
	
	@ManyToOne
	@JoinColumn(name = "LOCATION_ID")
	private Location location;
	
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location locationId) {
		this.location = locationId;
	}
	
	public String toString() {
		return getDepartmentId() + " " + getDepartmentName() + " " + getManager() + " " + getLocation(); 
	}
}
