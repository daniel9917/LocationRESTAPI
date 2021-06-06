package com.bancob.location.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bancob.location.app.controller.LocationController;

@SpringBootTest
class LocationControllerTest {

	@Test
	void test() {		
		LocationController name = new LocationController();		
		assertEquals("hello", name.hello());
	}

}
