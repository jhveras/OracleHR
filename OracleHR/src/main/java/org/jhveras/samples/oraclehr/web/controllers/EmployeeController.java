package org.jhveras.samples.oraclehr.web.controllers;

import java.util.List;

import org.jhveras.samples.oraclehr.entities.Employee;
import org.jhveras.samples.oraclehr.entities.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	private ResponseEntity<List<Employee>> listAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		
		if (employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
	private ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Long employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);
		
		if (employee == null) {			
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	private ResponseEntity<Employee> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucb) {
		Employee newEmployee = employeeRepository.save(employee);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb.path("/employees/{id}").buildAndExpand(newEmployee.getEmployeeId()).toUri());
		
		return new ResponseEntity<Employee>(newEmployee, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PUT)
	private ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
		Employee newEmployee = employeeRepository.findOne(employeeId);
		
		if (newEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		newEmployee.setCommissionPct(employee.getCommissionPct());
		newEmployee.setDepartment(employee.getDepartment());
		newEmployee.setEmail(employee.getEmail());
		newEmployee.setFirstName(employee.getFirstName());
		newEmployee.setHireDate(employee.getHireDate());
		newEmployee.setJob(employee.getJob());
		newEmployee.setLastName(employee.getLastName());
		newEmployee.setManager(employee.getManager());
		newEmployee.setPhoneNumber(employee.getPhoneNumber());
		newEmployee.setSalary(employee.getSalary());
		newEmployee = employeeRepository.save(newEmployee);
		
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
	}
}
