package org.jhveras.samples.oraclehr.entities.repositories;

import org.jhveras.samples.oraclehr.entities.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, String> {

}
