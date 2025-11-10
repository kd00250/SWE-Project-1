package edu.westga.cs1302.javafx_sample.test.model.stock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.javafx_sample.model.Stock;

class testConstructor {

	@Test
	public void testStockZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(0, true, "gold", "good", "12/12/2025");
		});
	}
	
	@Test
	public void testStockNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, null, "good", "12/12/2025");
		});
	}
	
	@Test
	public void testStockConditionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, "gold", null, "12/12/2025");
		});
	}
	
	@Test
	public void testStockExpDateNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, "gold", "good", null);
		});
	}
	
	@Test
	public void testStockNameEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, "", "goof", "12/12/2025");
		});
	}
	
	@Test
	public void testStockNameBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, " ", "good", "12/12/2025");
		});
	}
	
	@Test
	public void testStockConditionEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, "gold", "", "12/12/2025");
		});
	}
	
	@Test
	public void testStockConditionBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, "gold", " ", "12/12/2025");
		});
	}
	
	@Test
	public void testStockExpDateEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, "gold", "good", "");
		});
	}
	
	@Test
	public void testStockExpDateBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, true, "gold", "good", " ");
		});
	}
	
	@Test
	public void testValidConstructor() {
		Stock stock = new Stock(2, true, "gold", "good", "12/25/2999");
		
		assertEquals(2, stock.getSize());
		assertTrue(stock.getHasSpecialQualities());
		assertEquals("gold", stock.getName());
		assertEquals("good", stock.getCondition());
		assertEquals("12/25/2999", stock.getExpirationDate());
		
	}

}
