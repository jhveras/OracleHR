package org.jhveras.samples.oraclehr.entities;

import java.io.Serializable;
import java.util.Date;

public class JobHistoryId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9197199431099179912L;
	
	private long employeeId;	
	private Date startDate;

	public JobHistoryId() {
		
	}
	
	public JobHistoryId(long employee, Date startDate) {
		this.employeeId = employee;
		this.startDate = startDate;
	}

	public long getEmployee() {
		return employeeId;
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
				&& (employeeId == ((JobHistoryId)o).getEmployee()));		
	}
	
	public int hashCode() {
		return new Long(employeeId).hashCode() + startDate.hashCode();
	}

}
