package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.stock;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;

class testToString {

	@Test
	void testValidToString() {
		var stock = new Stock(1, new HashSet<>(), "Apple", "perfect", null, StockType.FOOD);
		var result = stock.toString();
		assertTrue(result.equals("Apple Quantity: 1"));
	}

}
