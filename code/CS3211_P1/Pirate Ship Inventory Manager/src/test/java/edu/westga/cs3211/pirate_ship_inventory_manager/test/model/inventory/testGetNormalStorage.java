package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.inventory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;

class testGetNormalStorage {

	@Test
	void testGetNormalStorageNames() {
		Inventory inventory = new Inventory();
		
		ArrayList<String> result = inventory.getNormalStorage(inventory.getCompartments());
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "Boxes");
		assertEquals(result.get(1), "Shelves");
	}
	
	@Test
	void testGetNormalStorageNamesNull() {
		Inventory inventory = new Inventory();
		
		assertThrows(IllegalArgumentException.class, () -> {
			inventory.getNormalStorage(null);
		});
	}

}
