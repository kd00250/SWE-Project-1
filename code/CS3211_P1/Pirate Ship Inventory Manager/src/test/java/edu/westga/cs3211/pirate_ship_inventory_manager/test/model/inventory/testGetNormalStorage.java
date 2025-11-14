package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.inventory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;

class testGetNormalStorage {

	@Test
	void testGetNormalStorageNames() {
		Inventory inventory = new Inventory();
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(10, qualities, "Paper","perfect", null);
		
		
		ArrayList<String> result = inventory.getNormalStorage(inventory.getCompartments(), stock);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "Boxes");
		assertEquals(result.get(1), "Shelves");
	}
	
	@Test
	void testGetNormalStorageNamesNull() {
		Inventory inventory = new Inventory();
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(10, qualities, "Paper","perfect", null);
		
		assertThrows(IllegalArgumentException.class, () -> {
			inventory.getNormalStorage(null, stock);
		});
	}

}
