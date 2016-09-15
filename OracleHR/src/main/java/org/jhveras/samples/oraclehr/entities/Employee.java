package org.jhveras.samples.oraclehr.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "EMPLOYEES")
public class Employee {
	
	@Id
	private long employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	
	private long jobId;
	
	private BigDecimal salary;
	
	private BigDecimal commissionPct;
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
	private Employee manager;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
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

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
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

	public Employee getManagerId() {
		return manager;
	}

	public void setManagerId(Employee managerId) {
		this.manager = managerId;
	}

	public Department getDepartmentId() {
		return department;
	}

	public void setDepartmentId(Department departmentId) {
		this.department = departmentId;
	}

}
