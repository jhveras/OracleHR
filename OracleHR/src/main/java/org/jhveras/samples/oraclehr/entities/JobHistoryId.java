package org.jhveras.samples.oraclehr.entities;

import java.io.Serializable;
import java.util.Date;

public class JobHistoryId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9197199431099179912L;
	
	private Employee employee;	
	private Date startDate;

	public JobHistoryId() {
		
	}
	
	public JobHistoryId(Employee employee, Date startDate) {
		this.employee = employee;
		this.startDate = startDate;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean equals(Object o) {
		return ((o instanceof JobHistoryId) 
				&& startDate.equals(((JobHistoryId)o).getStartDate()) 
				&& (employee == ((JobHistoryId)o).getEmployee()));		
	}
	
	public int hashCode() {
		return employee.hashCode() + startDate.hashCode();
	}

}
