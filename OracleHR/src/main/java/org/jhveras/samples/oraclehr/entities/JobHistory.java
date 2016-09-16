package org.jhveras.samples.oraclehr.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "JOB_HISTORY")
@IdClass(JobHistoryId.class)
public class JobHistory {

	@Id
	private long employeeId;
	
	@Id
	@Temporal(TemporalType.DATE)
	private Date startDate;	
	
	@ManyToOne
	@JoinColumn(name = "JOB_ID")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;

	public long getEmployee() {
		return employeeId;
	}

	public void setEmployee(long employee) {
		this.employeeId = employee;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
