package com.bancob.location.app;

import static org.junit.jupiter.api.Assertions.*;

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
	public void insertTest() {
		
		Location parent = new Location();
		parent.setArea_m2((long) 40);
		parent.setName("dani");
		
		this.locationService.createLocation(parent);
		
		Location dBparent = this.locationService.findById(parent.getId()).get();				
		assertNotNull(dBparent);
		
		
		//Adding a relation of a new record with an existing record		
		Location child = new Location ();
		child.setName("da");
		child.setArea_m2((long) 4);
		
		
		child.setParentLocation(parent);				
		
		this.locationService.createLocation(child);
		
		Location dBchild = this.locationService.findById(child.getId()).get();
		
		assertNotNull(dBchild);
		assertNotNull(dBchild.getParentLocation());
		
		//Adding a new relation which parent is the previous child just to make sure
		Location newchild = new Location ();
		newchild.setName("jo");
		newchild.setArea_m2((long) 3);
		
		newchild.setParentLocation(child);
		
		this.locationService.createLocation(newchild);
		
		Location dBnewchild = this.locationService.findById(newchild.getId()).get();
		
		assertNotNull(dBnewchild);
		assertNotNull(dBnewchild.getParentLocation());

		
	}

}
