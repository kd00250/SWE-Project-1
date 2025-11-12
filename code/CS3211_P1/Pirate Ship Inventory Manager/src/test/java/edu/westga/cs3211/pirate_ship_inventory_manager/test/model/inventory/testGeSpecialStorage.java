package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.inventory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;

class testGeSpecialStorage {

	@Test
	void testGetNormalStorageNames() {
		Inventory inventory = new Inventory();
		
		ArrayList<String> result = inventory.getSpecialStorage(inventory.getCompartments());
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "Special Storage 1");
		assertEquals(result.get(1), "Special Storage 2");
	}
	
	@Test
	void testGetNormalStorageNamesNull() {
		Inventory inventory = new Inventory();
		
		assertThrows(IllegalArgumentException.class, () -> {
			inventory.getSpecialStorage(null);
		});
	}


}
