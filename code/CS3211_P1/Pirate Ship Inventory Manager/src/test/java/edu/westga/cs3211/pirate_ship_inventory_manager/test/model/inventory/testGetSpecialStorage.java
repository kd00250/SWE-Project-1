package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.inventory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;

class testGetSpecialStorage {

	@Test
	void testGetSpecialStorageAllNames() {
		Inventory inventory = new Inventory();
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.FLAMMABLE);
        qualities.add(SpecialQuality.LIQUID);
        qualities.add(SpecialQuality.PERISHABLE);
		Stock stock = new Stock(10, qualities, "Paper","perfect", "12/12/2025");
		
		ArrayList<String> result = inventory.getSpecialStorage(inventory.getCompartments(), stock);
		assertEquals(result.size(), 3);
		assertEquals(result.get(0), "Flammable Storage");
		assertEquals(result.get(1), "Liquid Storage");
		assertEquals(result.get(2), "Perishable Storage");
	}
	
	@Test
	void testGetSpecialStorageTwoNames() {
		Inventory inventory = new Inventory();
		Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.LIQUID);
        qualities.add(SpecialQuality.PERISHABLE);
		Stock stock = new Stock(10, qualities, "Paper","perfect", "12/12/2025");
		
		ArrayList<String> result = inventory.getSpecialStorage(inventory.getCompartments(), stock);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "Liquid Storage");
		assertEquals(result.get(1), "Perishable Storage");
	}
	
	@Test
	void testGetSpecialStorageOneName() {
		Inventory inventory = new Inventory();
		Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.PERISHABLE);
		Stock stock = new Stock(10, qualities, "Paper","perfect", "12/12/2025");
		
		ArrayList<String> result = inventory.getSpecialStorage(inventory.getCompartments(), stock);
		assertEquals(result.size(), 1);
		assertEquals(result.get(0), "Perishable Storage");
	}
	
	
	@Test
	void testGetSpecialStorageNamesNull() {
		Inventory inventory = new Inventory();
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(10, qualities, "Paper","perfect", null);
		
		assertThrows(IllegalArgumentException.class, () -> {
			inventory.getSpecialStorage(null, stock );
		});
	}
	
	@Test
	void testGetSpecialStorageStockNull() {
		Inventory inventory = new Inventory();
		
		assertThrows(IllegalArgumentException.class, () -> {
			inventory.getSpecialStorage(inventory.getCompartments(), null);
		});
	}


}
