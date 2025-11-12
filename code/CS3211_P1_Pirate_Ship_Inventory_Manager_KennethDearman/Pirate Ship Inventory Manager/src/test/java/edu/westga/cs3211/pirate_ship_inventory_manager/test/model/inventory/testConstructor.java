package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;

class testConstructor {

	@Test
	void testValidConstructor() {
		Inventory inventory = new Inventory();
		inventory.getCompartments();
		
		assertEquals(inventory.getCompartments().get(0).getName(), "Boxes");
		assertEquals(inventory.getCompartments().get(0).getCapacity(), 10);
		assertEquals(inventory.getCompartments().get(0).getIsSpecialQualitiesStorage(), false);
		
		assertEquals(inventory.getCompartments().get(1).getName(), "Shelves");
		assertEquals(inventory.getCompartments().get(1).getCapacity(), 10);
		assertEquals(inventory.getCompartments().get(1).getIsSpecialQualitiesStorage(), false);
		
		assertEquals(inventory.getCompartments().get(2).getName(), "Special Storage 1");
		assertEquals(inventory.getCompartments().get(2).getCapacity(), 15);
		assertEquals(inventory.getCompartments().get(2).getIsSpecialQualitiesStorage(), true);
		
		assertEquals(inventory.getCompartments().get(3).getName(), "Special Storage 2");
		assertEquals(inventory.getCompartments().get(3).getCapacity(), 15);
		assertEquals(inventory.getCompartments().get(3).getIsSpecialQualitiesStorage(), true);
	}

}
