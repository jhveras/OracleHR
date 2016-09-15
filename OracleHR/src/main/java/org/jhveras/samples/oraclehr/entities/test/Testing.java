package org.jhveras.samples.oraclehr.entities.test;

import java.util.List;

import org.jhveras.samples.oraclehr.entities.Country;
import org.jhveras.samples.oraclehr.entities.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Testing {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Testing() {
		
	}
	
	public void test() {
		List<Country> countries = countryRepository.findAll();
		
		for (Country c: countries) {
			System.out.println(c.toString());
		}
	}
	
}
