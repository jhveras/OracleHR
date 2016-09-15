package org.jhveras.samples.oraclehr;

import org.jhveras.samples.oraclehr.entities.Employee;
import org.jhveras.samples.oraclehr.entities.Region;
import org.jhveras.samples.oraclehr.entities.repositories.EmployeeRepository;
import org.jhveras.samples.oraclehr.entities.repositories.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication	
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}
	
	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {

			for (Employee region : repository.findAll()) {
				log.info(region.toString());
			}
		};
	}

}
