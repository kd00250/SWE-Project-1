package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.compartment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;

public class testGetStockOfType {

	@Test
	void testWhenStockTypeValidWithOneStockMatching() {
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004", StockType.FOOD);
		box.addStock(stock);
		assertEquals(stock, box.getStockOfType(StockType.FOOD).get(0));
	}
	
	@Test
	void testWhenMultipleValidStockWithMatchingType() {
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock0 = new Stock(2, qualities, "gold", "good", "12/12/2004", StockType.FOOD);
		Stock stock1 = new Stock(3, qualities, "gold", "good", "12/12/2004", StockType.FOOD);
		Stock stock2 = new Stock(4, qualities, "gold", "good", "12/12/2004", StockType.FOOD);
		box.addStock(stock0);
		box.addStock(stock1);
		box.addStock(stock2);
		var matchingStock = box.getStockOfType(StockType.FOOD);
		assertEquals(stock0, matchingStock.get(0));
		assertEquals(stock1, matchingStock.get(1));
		assertEquals(stock2, matchingStock.get(2));
	}
	
	@Test
	void testWhenMultipleValidStockSomeMatchOthersDont() {
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock0 = new Stock(2, qualities, "gold", "good", "12/12/2004", StockType.FOOD);
		Stock stock1 = new Stock(3, qualities, "gold", "good", "12/12/2004", StockType.DEFAULT);
		Stock stock2 = new Stock(4, qualities, "gold", "good", "12/12/2004", StockType.FOOD);
		box.addStock(stock0);
		box.addStock(stock1);
		box.addStock(stock2);
		var matchingStock = box.getStockOfType(StockType.FOOD);
		assertEquals(stock0, matchingStock.get(0));
		assertEquals(stock2, matchingStock.get(1));
	}
	
	@Test
	void testWhenStockTypeNull() {
		Compartment box = new Compartment("barrel", 25, false);
		assertThrows(IllegalArgumentException.class, () -> {
			box.getStockOfType(null);
		});
	}
}
