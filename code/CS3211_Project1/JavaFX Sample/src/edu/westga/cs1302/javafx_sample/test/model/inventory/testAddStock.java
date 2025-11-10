package edu.westga.cs1302.javafx_sample.test.model.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample.model.Inventory;
import edu.westga.cs1302.javafx_sample.model.Stock;

class testAddStock {

	@Test
	void testAddNullStock() {
		Inventory storage = new Inventory();
		assertThrows(IllegalArgumentException.class, () -> {
			storage.addStock(null);
		});
	}
	
	@Test
	void testAddValidSpecialQualityStock() {
		Inventory storage = new Inventory();
		Stock stock = new Stock(2, true, "gold", "good", "12/25/2999");
		
		assertTrue(storage.addStock(stock));
		assertEquals(storage.getInventory().get(0).getSize(), stock.getSize());
		assertEquals(storage.getInventory().get(0).getHasSpecialQualities(), stock.getHasSpecialQualities());
		assertEquals(storage.getInventory().get(0).getName(), stock.getName());
		assertEquals(storage.getInventory().get(0).getCondition(), stock.getCondition());
		assertEquals(storage.getInventory().get(0).getExpirationDate(), stock.getExpirationDate());
	}
	
	@Test
	void testAddMultipleValidSpecialQualityStock() {
		Inventory storage = new Inventory();
		Stock stock = new Stock(2, true, "gold", "good", "12/25/2999");
		Stock stock2 = new Stock(2, true, "gold", "good", "12/25/2999");
		storage.addStock(stock);
		
		assertTrue(storage.addStock(stock2));
		assertEquals(storage.getInventory().get(1).getSize(), stock2.getSize());
		assertEquals(storage.getInventory().get(1).getHasSpecialQualities(), stock2.getHasSpecialQualities());
		assertEquals(storage.getInventory().get(1).getName(), stock2.getName());
		assertEquals(storage.getInventory().get(1).getCondition(), stock2.getCondition());
		assertEquals(storage.getInventory().get(1).getExpirationDate(), stock2.getExpirationDate());
	}
	
	@Test
	void testMultipleAddValidStock() {
		Inventory storage = new Inventory();
		Stock stock = new Stock(2, false, "gold", "good", "12/25/2999");
		Stock stock2 = new Stock(2, false, "gold", "good", "12/25/2999");
		storage.addStock(stock);
		
		assertTrue(storage.addStock(stock2));
		assertEquals(storage.getInventory().get(1).getSize(), stock2.getSize());
		assertEquals(storage.getInventory().get(1).getHasSpecialQualities(), stock2.getHasSpecialQualities());
		assertEquals(storage.getInventory().get(1).getName(), stock2.getName());
		assertEquals(storage.getInventory().get(1).getCondition(), stock2.getCondition());
		assertEquals(storage.getInventory().get(1).getExpirationDate(), stock2.getExpirationDate());
	}
	
	@Test
	void testAddInvalidSpecialQualityStock() {
		Inventory storage = new Inventory();
		Stock stock = new Stock(27, true, "gold", "good", "12/25/2999");
		
		assertFalse(storage.addStock(stock));
	}
	
	@Test
	void testAddInvalidStock() {
		Inventory storage = new Inventory();
		Stock stock = new Stock(999, false, "gold", "good", "12/25/2999");
		
		assertFalse(storage.addStock(stock));
	}

}
