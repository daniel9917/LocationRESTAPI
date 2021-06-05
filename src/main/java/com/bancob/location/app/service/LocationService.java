package com.bancob.location.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancob.location.app.entity.Location;
import com.bancob.location.app.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locationRepository;
	
	public LocationService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public Location createLocation (Location location) {		
		return this.locationRepository.save(location);		
	}
	
	
	public Optional<Location> findById(Long id){
		
		return this.locationRepository.findById(id);
		
	}
	
	public Iterable<Location> findAll() {
		return this.locationRepository.findAll();
		
	}

}
