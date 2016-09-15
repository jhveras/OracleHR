package org.jhveras.samples.oraclehr.entities.repositories;

import org.jhveras.samples.oraclehr.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
