package org.jhveras.samples.oraclehr.web.controllers;

import java.util.List;

import org.jhveras.samples.oraclehr.entities.Job;
import org.jhveras.samples.oraclehr.entities.repositories.JobRepository;
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
public class JobController {

	@Autowired
	private JobRepository jobRepository;
	
	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> listAllJobs() {
		List<Job> jobs = jobRepository.findAll();
		
		if (jobs.isEmpty()) {
			return new ResponseEntity<List<Job>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.GET)
	public ResponseEntity<Job> getJob(@PathVariable("jobId") String jobId) {
		Job job = jobRepository.findByJobId(jobId);
		
		if (job == null) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobs", method = RequestMethod.POST)
	public ResponseEntity<Job> createJob(@RequestBody Job job, UriComponentsBuilder ucb) {
		Job newJob = jobRepository.findByJobId(job.getJobId());
		
		if (newJob != null) {
			return new ResponseEntity<Job>(HttpStatus.CONFLICT);
		}
		
		newJob = jobRepository.save(job);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb.path("/jobs/{id}").buildAndExpand(newJob.getJobId()).toUri());
		
		return new ResponseEntity<Job>(newJob, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(@PathVariable("jobId") String jobId, @RequestBody Job job) {
		Job currentJob = jobRepository.findByJobId(jobId);
		
		if (currentJob == null) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		
		currentJob.setJobTitle(job.getJobTitle());
		currentJob.setMaxSalary(job.getMaxSalary());
		currentJob.setMinSalary(job.getMinSalary());
		currentJob = jobRepository.save(job);		
		
		return new ResponseEntity<Job>(currentJob, HttpStatus.OK);
	}
}
