package org.jhveras.samples.oraclehr.web.controllers;

import java.util.List;

import org.jhveras.samples.oraclehr.entities.Region;
import org.jhveras.samples.oraclehr.entities.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController {

	@Autowired
	RegionRepository regionRepository;
	
	@RequestMapping(value = "/regions", method = RequestMethod.GET)
	public ResponseEntity<List<Region>> listAllRegions() {
		List<Region> regions = regionRepository.findAll();
		
		if (regions.isEmpty()) {
			return new ResponseEntity<List<Region>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Region>>(regions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/regions/{regionId}", method = RequestMethod.GET)
	public ResponseEntity<Region> getRegion(@PathVariable("regionId") long regionId) {
		Region region = regionRepository.findOne(regionId);
		
		if (region == null) {
			return new ResponseEntity<Region>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Region>(region, HttpStatus.OK);
	}
}
