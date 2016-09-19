package org.jhveras.samples.oraclehr.web.controllers;

import java.util.List;

import org.jhveras.samples.oraclehr.entities.Location;
import org.jhveras.samples.oraclehr.entities.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController {

	@Autowired
	LocationRepository locationRepository;
	
	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	public ResponseEntity<List<Location>> listAllLocations() {
		List<Location> locations = locationRepository.findAll();
		
		if (locations.isEmpty()) {
			return new ResponseEntity<List<Location>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/locations/{locationId}", method = RequestMethod.GET)
	public ResponseEntity<Location> getLocation(@PathVariable("locationId") Long locationId) {
		Location location = locationRepository.findOne(locationId);
		
		if (location == null) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
}
