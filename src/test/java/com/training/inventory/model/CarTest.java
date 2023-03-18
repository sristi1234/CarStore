package com.training.inventory.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CarTest {
	
	
	
	
	@Test
	public void testCarConstructorIsNotNull() {
		
		assertNotNull(new Car());
	}
	
	@Test
	public void testCarParameterized1ConstructorIsNotNull() {
		
		assertNotNull(new Car(1,"BMW X5", "BMW", 1000, "Black", "Available"));
	}
	
	@Test
	public void testCarConstructorParameterized2IsNotNull() {
		
		assertNotNull(new Car("BMW X5", "BMW", 1000, "Black", "Available"));
	}

}
