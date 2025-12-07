package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.stock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;

public class testSetType {
	@Test
	void testWhenTypeNull() {
        Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.FLAMMABLE);
        qualities.add(SpecialQuality.LIQUID);
        qualities.add(SpecialQuality.PERISHABLE);
     
        Stock stock = new Stock(2, qualities, "juice", "usable", "12/12/2025", StockType.FOOD);
        
        assertThrows(IllegalArgumentException.class, () -> {
        	stock.setType(null);
        });
	}
	
	@Test
	void testWhenTypeValid() {
        Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.FLAMMABLE);
        qualities.add(SpecialQuality.LIQUID);
        qualities.add(SpecialQuality.PERISHABLE);
     
        Stock stock = new Stock(2, qualities, "juice", "usable", "12/12/2025", StockType.FOOD);
        stock.setType(StockType.MUNITION);
        assertTrue(stock.getHasSpecialQualities());
        assertTrue(stock.isFlammable());
        assertTrue(stock.isLiquid());
        assertTrue(stock.isPerishable());
        assertEquals("12/12/2025", stock.getExpirationDate());
        assertEquals(StockType.MUNITION, stock.getType());
	}
}
