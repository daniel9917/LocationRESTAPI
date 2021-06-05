package com.bancob.location.app.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bancob.location.app.entity.Location;
import com.bancob.location.app.service.LocationService;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Location> listAll(){
		return this.locationService.findAll();
	}
	
	@PostMapping(path = {"/create", "/create/"})
	public @ResponseBody Location create(@RequestBody Location location) {		
		return this.locationService.createLocation(location);
		
	}
	
	@GetMapping("/get/{id}")
	public @ResponseBody Location getById (@PathVariable int id) {
		Location parentLocation;
		parentLocation  = this.locationService.findById((long)id).get();					
		return parentLocation;
	}
	
	@GetMapping(path = {"/",""})
	public String hello () {
		return "hello";
	}
	
	
	

}
