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
		assertEquals(inventory.getCompartments().get(0).getCapacity(), 30);
		assertEquals(inventory.getCompartments().get(0).getIsSpecialQualitiesStorage(), false);
		
		assertEquals(inventory.getCompartments().get(1).getName(), "Shelves");
		assertEquals(inventory.getCompartments().get(1).getCapacity(), 30);
		assertEquals(inventory.getCompartments().get(1).getIsSpecialQualitiesStorage(), false);
		
		assertEquals(inventory.getCompartments().get(2).getName(), "Flammable Storage");
		assertEquals(inventory.getCompartments().get(2).getCapacity(), 25);
		assertEquals(inventory.getCompartments().get(2).getIsSpecialQualitiesStorage(), true);
		
		assertEquals(inventory.getCompartments().get(3).getName(), "Liquid Storage");
		assertEquals(inventory.getCompartments().get(3).getCapacity(), 25);
		assertEquals(inventory.getCompartments().get(3).getIsSpecialQualitiesStorage(), true);
		
		assertEquals(inventory.getCompartments().get(4).getName(), "Perishable Storage");
		assertEquals(inventory.getCompartments().get(4).getCapacity(), 25);
		assertEquals(inventory.getCompartments().get(4).getIsSpecialQualitiesStorage(), true);
	}

}
