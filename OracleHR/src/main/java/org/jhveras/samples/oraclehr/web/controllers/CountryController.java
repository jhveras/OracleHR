package org.jhveras.samples.oraclehr.web.controllers;

import java.util.List;

import org.jhveras.samples.oraclehr.entities.Country;
import org.jhveras.samples.oraclehr.entities.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@Autowired
	CountryRepository countryRepository;
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> listAllCountries() {
		List<Country> countries = countryRepository.findAll();
		
		if (countries.isEmpty()) {
			return new ResponseEntity<List<Country>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countries/{countryId}", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountry(@PathVariable("countryId") String countryId) {
		Country country = countryRepository.findByCountryId(countryId);
		
		if (country == null) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
}
