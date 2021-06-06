package com.bancob.location.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bancob.location.app.entity.Location;
import com.bancob.location.app.service.LocationService;


@SpringBootTest
class LocationRepositoryTest {

	@Autowired
	LocationService locationService;
	
	@Test
	@Disabled
	public void insertTest() {
		
		Location parent = new Location();
		parent.setArea_m2((long) 5000);
		parent.setName("Casitlla");
		
		this.locationService.createLocation(parent);
		
		Location dBparent = this.locationService.findById(parent.getId()).get();				
		assertNotNull(dBparent);
		
		
		//Adding a relation of a new record with an existing record		
		Location child = new Location ();
		child.setName("Techo");
		child.setArea_m2((long) 1000);
		
		
		child.setParentLocation(parent);				
		
		this.locationService.createLocation(child);
		
		Location dBchild = this.locationService.findById(child.getId()).get();
		
		assertNotNull(dBchild);
		assertNotNull(dBchild.getParentLocation());
		
		//Adding a new relation which parent is the previous child just to make sure
		Location newchild = new Location ();
		newchild.setName("Terrazas");
		newchild.setArea_m2((long) 200);
		
		newchild.setParentLocation(child);
		
		this.locationService.createLocation(newchild);
		
		Location dBnewchild = this.locationService.findById(newchild.getId()).get();
		
		assertNotNull(dBnewchild);
		assertNotNull(dBnewchild.getParentLocation());

		
	}

}
