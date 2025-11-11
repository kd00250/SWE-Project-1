package edu.westga.cs3211.swe_project1.test.model.compartment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.swe_project1.model.Compartment;
import edu.westga.cs3211.swe_project1.model.SpecialQuality;
import edu.westga.cs3211.swe_project1.model.Stock;

class testAddStock {

	@Test
	void testAddStockNull() {
		Compartment box = new Compartment("barrel", 25, true );
		assertThrows(IllegalArgumentException.class, () -> {
			box.addStock(null);
		});
	}
	
	@Test
	void testAddStockFalseNoSpace() {
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(26, qualities, "gold", "good", "12/12/2004");
		
		assertFalse(box.addStock(stock));
	}
	
	@Test
	void testAddStockTrue() {
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		
		assertTrue(box.addStock(stock));
	}
	
	@Test
	void testAddStockFalse() {
		Compartment box = new Compartment("barrel", 25, true );
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(26, qualities, "gold", "good", "12/12/2004");
		
		assertFalse(box.addStock(stock));
	}
	
	@Test
	void testAddStockTrueStockHasSpecialQualities() {
		Compartment box = new Compartment("barrel", 25, true );
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.FLAMMABLE);
		Stock stock = new Stock(2, qualities, "gold", "good", "12/12/2004");
		
		assertTrue(box.addStock(stock));
	}
	
	@Test
	void testAddStockFalseStockHasSpecialQualities() {
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.FLAMMABLE);
		Stock stock = new Stock(26, qualities, "gold", "good", "12/12/2004");
		
		assertFalse(box.addStock(stock));
	}

}
