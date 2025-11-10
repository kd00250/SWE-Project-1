package edu.westga.cs1302.javafx_sample.test.model.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample.model.Inventory;
import edu.westga.cs1302.javafx_sample.model.Stock;

class testHasSpecialQualityFreeSpace {

	@Test
	void testInventoryHasFreeSpace() {
		Inventory inventory = new Inventory();
		Stock stock = new Stock(2, true, "gold", "good", "12/12/2025");
		assertTrue(inventory.hasSpecialQualityFreeSpace(stock));
	}
	
	@Test
	void testInventoryDoesNotFreeSpace() {
		Inventory inventory = new Inventory();
		Stock stock = new Stock(999, true, "gold", "good", "12/12/2025");
		assertFalse(inventory.hasSpecialQualityFreeSpace(stock));
	}

}
