package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.compartment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;

class testHasFreeSpace {

	@Test
	void testHasFreeSpaceTrue() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		
		assertTrue(box.hasFreeSpace(stock));
	}
	
	@Test
	void testHasFreeSpaceFalse() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(26, qualities, "gold", "good", "12/12/2004");
		
		assertFalse(box.hasFreeSpace(stock));
	}
	
	@Test
	void testHasFreeSpaceMultipleItemsTrue() {
		Compartment box = new Compartment("barrel", 25, false );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		Stock stock2 = new Stock(2, qualities, "gold", "good", "12/12/2004");
		box.addStock(stock);
		
		assertTrue(box.hasFreeSpace(stock2));
	}
	

}
