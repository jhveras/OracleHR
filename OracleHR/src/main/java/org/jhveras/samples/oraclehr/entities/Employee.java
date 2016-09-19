package org.jhveras.samples.oraclehr.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "EMPLOYEES")
public class Employee {
	
	@Id
	@SequenceGenerator(
	        name="EMPLOYEE_SEQUENCE_GENERATOR",
	        sequenceName="EMPLOYEES_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMPLOYEE_SEQUENCE_GENERATOR")
	@Column(name = "EMPLOYEE_ID")
	private long employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	
	@ManyToOne
	@JoinColumn(name = "JOB_ID")
	private Job job;
	
	private BigDecimal salary;
	
	private BigDecimal commissionPct;
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	@JsonBackReference
	private Department department;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job jobId) {
		this.job = jobId;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee managerId) {
		this.manager = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department departmentId) {
		this.department = departmentId;
	}

}
