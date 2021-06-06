package com.bancob.location.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bancob.location.app.entity.Location;

@SpringBootTest
class LocationEntityTests {

	@Test
	void test() {
		
		Location colombia = new Location("Colombia", (long)1143000, null);
		
		assertEquals("Colombia", colombia.getName().toString());		
		assertEquals(1143000, colombia.getArea_m2().intValue());
		
		
		Location cundinamarca = new Location("Cundinamarca", (long)4000, colombia);
		
		assertEquals("Cundinamarca", cundinamarca.getName().toString());
		assertEquals(4000, cundinamarca.getArea_m2().intValue());
		assertEquals("Colombia", cundinamarca.getParentLocation().getName().toString());		
		assertEquals(1143000, cundinamarca.getParentLocation().getArea_m2().intValue());
	}

}
