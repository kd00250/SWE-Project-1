package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.compartment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;

class testDoesConatinStockOfType {

	@Test
	void testCompartmentDoesHaveStockType() {
		var compartment = new Compartment("Barrel", 10, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		var stock = new Stock(1, qualities, "Apple", "perfect", null, StockType.FOOD);
		compartment.addStock(stock);
		
		var result = compartment.doesContainStockOfType(StockType.FOOD);
		assertTrue(result);
	}
	
	@Test
	void testCompartmentDoesntHaveStockType() {
		var compartment = new Compartment("Barrel", 10, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		var stock = new Stock(1, qualities, "Apple", "perfect", null, StockType.FOOD);
		compartment.addStock(stock);
		
		var result = compartment.doesContainStockOfType(StockType.DEFAULT);
		assertFalse(result);
	}
	
	@Test
	void testCompartmentDoesntHaveStockTypeOrStock() {
		var compartment = new Compartment("Barrel", 10, false);
		
		var result = compartment.doesContainStockOfType(StockType.DEFAULT);
		assertFalse(result);
	}

}
