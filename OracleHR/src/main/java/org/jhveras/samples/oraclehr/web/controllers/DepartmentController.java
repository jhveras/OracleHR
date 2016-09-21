package org.jhveras.samples.oraclehr.web.controllers;

import java.util.List;

import org.jhveras.samples.oraclehr.entities.Department;
import org.jhveras.samples.oraclehr.entities.repositories.DepartmentRepository;
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
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;
	
	/*
	 * 
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> listAllDepartments() {
		List<Department> departments = departmentRepository.findAll();
		
		if (departments.isEmpty()) {
			return new ResponseEntity<List<Department>>(HttpStatus.NOT_FOUND);
		}
				
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}
	
	/*
	 * 
	 */
	@RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.GET)
	public ResponseEntity<Department> getDepartment(@PathVariable("departmentId") Long departmentId) {
		Department department = departmentRepository.findOne(departmentId);
		
		if (department == null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	
	/*
	 * 
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.POST)
	public ResponseEntity<Department> createDepartment(@RequestBody Department department, UriComponentsBuilder ucb) {
		Department newDepartment = departmentRepository.findByDepartmentName(department.getDepartmentName());
		
		if (newDepartment != null) {
			return new ResponseEntity<Department>(department, HttpStatus.CONFLICT);
		}
		
		System.out.print("Department from request: ");
		System.out.println(department.toString());
		
		newDepartment = departmentRepository.save(department);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb.path("/departments/{id}").buildAndExpand(newDepartment.getDepartmentId()).toUri());
		
		return new ResponseEntity<Department>(newDepartment, headers, HttpStatus.CREATED);
	}
	
	/*
	 * 
	 */
	@RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.PUT)
	public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department department) {
		Department updateDepartment = departmentRepository.findOne(departmentId);
		
		if (updateDepartment == null) {
			return new ResponseEntity<Department>(department, HttpStatus.NOT_FOUND);
		}
		
		updateDepartment.setDepartmentName(department.getDepartmentName());
		updateDepartment.setManager(department.getManager());
		updateDepartment.setLocation(department.getLocation());
		updateDepartment = departmentRepository.save(updateDepartment);		
		
		return new ResponseEntity<Department>(updateDepartment, HttpStatus.OK);
	}
}
