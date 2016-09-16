package org.jhveras.samples.oraclehr.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "JOBS")
public class Job {

	@Id
	private String jobId;
	
	private String jobTitle;
	
	private BigDecimal minSalary;
	
	private BigDecimal maxSalary;
	
	public Job() {
		
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public BigDecimal getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}
}
