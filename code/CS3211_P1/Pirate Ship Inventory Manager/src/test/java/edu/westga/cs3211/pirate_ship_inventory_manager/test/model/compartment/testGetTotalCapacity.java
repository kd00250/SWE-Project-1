package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.compartment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;

class testGetTotalCapacity {

	@Test
	void testBoxTotalCapacity() {
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		box.addStock(stock);
		
		assertEquals(box.getRemainingCapacity(), 23);
	}
	
	@Test
	void testBoxTotalCapacityNoStocksAdded() {
		Compartment box = new Compartment("barrel", 25, false);
		
		assertEquals(box.getRemainingCapacity(), 25);
	}

}
