package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.compartment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;

class testRemoveStock {

	@Test
	void testNullStock() {
		Compartment box = new Compartment("barrel", 25, true );
		assertThrows(IllegalArgumentException.class, () -> {
			box.removeStock(null, 1);
		});
	}
	
	@Test
	void testZeroQuantity() {
		Compartment box = new Compartment("barrel", 25, true );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		assertThrows(IllegalArgumentException.class, () -> {
			box.removeStock(stock, 0);
		});
	}

	@Test
	void testRemoveStockCompletely() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		box.addStock(stock);
		boolean result = box.removeStock(stock, 2);
		
		assertTrue(result);
		assertEquals(box.getStorage().size(), 0);
	}
	
	@Test
	void testRemoveStockPartially() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		box.addStock(stock);
		boolean result = box.removeStock(stock, 1);
		
		assertTrue(result);
		assertEquals(box.getStorage().size(), 1);
		assertEquals(box.getStorage().get(0).getQuantity(), 1);
	}
	
	@Test
	void testRemoveStockNotAdded() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		boolean result = box.removeStock(stock, 1);
		
		assertFalse(result);
	}
	
	@Test
	void testRemoveStockMoreQuantityThanStored() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		box.addStock(stock);
		boolean result = box.removeStock(stock, 3);
		
		assertFalse(result);
	}
	
	@Test
	void testRemoveStockNotInStorage() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		Stock stock2 = new Stock(6, qualities, "Sugar", "good", "12/12/2004");
		box.addStock(stock);
		boolean result = box.removeStock(stock2, 3);
		
		assertFalse(result);
	}
	
}
