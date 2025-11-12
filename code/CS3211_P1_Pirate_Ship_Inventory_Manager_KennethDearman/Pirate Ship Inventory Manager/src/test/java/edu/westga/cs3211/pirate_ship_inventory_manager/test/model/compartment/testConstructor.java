package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.compartment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;

class testConstructor {

	@Test
	void testValidConstructor() {
		Compartment box = new Compartment("barrel", 25, true );
		
		assertEquals(box.getCapacity(), 25);
		assertEquals(box.getName(), "barrel");
		assertTrue(box.getIsSpecialQualitiesStorage());
		assertTrue(box.getStorage().isEmpty());
	}
	
	@Test
	void testInvalidConstructorCapacityZero() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Compartment("barrel", 0, true );
		});
	}

}
