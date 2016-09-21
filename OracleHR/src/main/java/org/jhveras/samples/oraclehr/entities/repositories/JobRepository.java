package org.jhveras.samples.oraclehr.entities.repositories;

import org.jhveras.samples.oraclehr.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {

	Job findByJobId(String jobId);
}
