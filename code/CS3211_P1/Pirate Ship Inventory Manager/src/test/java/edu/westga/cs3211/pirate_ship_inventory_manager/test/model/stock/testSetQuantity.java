package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.stock;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;

class testSetQuantity {

	@Test
	void testNegativeQuantity() {
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(10, qualities, "Paper","perfect", null);
        
        assertThrows(IllegalArgumentException.class, () -> {
        	stock.setQuantity(-1);
        });
	}
	
	@Test
	void testValidQuantity() {
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(10, qualities, "Paper","perfect", null);
        stock.setQuantity(3);
        
        assertEquals(3, stock.getQuantity());
        
	}
	
	@Test
	void testValidQuantityZero() {
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(10, qualities, "Paper","perfect", null);
        stock.setQuantity(0);
        
        assertEquals(0, stock.getQuantity());
        
	}

}
