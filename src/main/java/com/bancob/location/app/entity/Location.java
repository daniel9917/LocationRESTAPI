package com.bancob.location.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = "childLocations")
public class Location implements Serializable{		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
		
	private Long area_m2;
	
	private Location parentLocation;
		
//	private Set <Location> InternalLocations = new HashSet<Location>();
//	
//	
//	public Set<Location> getInternalLocations() {
//		return InternalLocations;
//	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getArea_m2() {
		return area_m2;
	}

	public void setArea_m2(Long area_m2) {
		this.area_m2 = area_m2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentLocationId")
	public Location getParentLocation() {
		return parentLocation;
	}

	public void setParentLocation(Location parentLocation) {
		this.parentLocation = parentLocation;
	}

//	public void setInternalLocations(Set<Location> internalLocations) {
//		InternalLocations = internalLocations;
//	}	
	
	public Location() {		
		// TODO Auto-generated constructor stub
	}
	
	public Location(String name, Long area_m2, Location parentLocation) {
		this.name = name;
		this.area_m2 = area_m2;
		this.parentLocation = parentLocation;
	}

	
	
	
	
	
	
	
	
	
	
	

}
