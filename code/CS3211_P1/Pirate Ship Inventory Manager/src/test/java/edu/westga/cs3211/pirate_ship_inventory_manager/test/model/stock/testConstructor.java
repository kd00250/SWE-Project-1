package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.stock;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;

class testConstructor {

	@Test
	public void testStockQuantityZero() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(0, qualities, "gold", "good", "12/12/2025");
		});
	}
	
	@Test
	public void testStockNameNull() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, null, "good", "12/12/2025");
		});
	}
	
	@Test
	public void testStockConditionNull() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, "gold", null, "12/12/2025");
		});
	}
	
	@Test
	public void testStockNameEmpty() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, "", "goof", "12/12/2025");
		});
	}
	
	@Test
	public void testStockNameBlank() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, " ", "good", "12/12/2025");
		});
	}
	
	@Test
	public void testStockConditionEmpty() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, "gold", "", "12/12/2025");
		});
	}
	
	@Test
	public void testStockConditionBlank() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, "gold", " ", "12/12/2025");
		});
	}
	
	@Test
	public void testStockExpDateNull() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, "gold", "good", null);
		});
	}
	
	@Test
	public void testStockExpDateEmpty() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, "gold", "good", "");
		});
	}
	
	@Test
	public void testStockExpDateBlank() {
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
		assertThrows(IllegalArgumentException.class, () -> {
			new Stock(2, qualities, "gold", "good", " ");
		});
	}
	
	@Test
	public void testValidConstructor() {
		Set<SpecialQuality> qualities = new HashSet<>();
		Stock stock = new Stock(2, qualities, "gold", "good", "12/25/2999");
		
		assertEquals(2, stock.getQuantity());
		assertFalse(stock.getHasSpecialQualities());
		assertEquals("gold", stock.getName());
		assertEquals("good", stock.getCondition());
		assertEquals("12/25/2999", stock.getExpirationDate());
		
	}
	
	@Test
    void testConstructorWithNoSpecialQualities() {
        Set<SpecialQuality> qualities = new HashSet<>();
        
        Stock stock = new Stock(10, qualities, "Paper","perfect", null);
        
        assertEquals(10, stock.getQuantity());
        assertEquals("Paper", stock.getName());
        assertEquals("perfect", stock.getCondition());
        assertFalse(stock.getHasSpecialQualities());
        assertFalse(stock.isFlammable());
        assertFalse(stock.isLiquid());
        assertFalse(stock.isPerishable());
        assertNull(stock.getExpirationDate());
    }

    @Test
    void testConstructorWithFlammableOnly() {
        Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.FLAMMABLE);
        
        Stock stock = new Stock(5, qualities, "Fuel", "usable", null);
        
        assertTrue(stock.getHasSpecialQualities());
        assertTrue(stock.isFlammable());
        assertFalse(stock.isLiquid());
        assertFalse(stock.isPerishable());
    }

    @Test
    void testConstructorWithLiquidOnly() {
        Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.LIQUID);
        
        Stock stock = new Stock(3, qualities, "Water", "perfect", null);
        
        assertTrue(stock.getHasSpecialQualities());
        assertFalse(stock.isFlammable());
        assertTrue(stock.isLiquid());
        assertFalse(stock.isPerishable());
    }

    @Test
    void testConstructorWithPerishableOnly() {
        Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.PERISHABLE);
        
        Stock stock = new Stock(20, qualities, "Apples", "perfect", "12/12/2025");
        
        assertTrue(stock.getHasSpecialQualities());
        assertFalse(stock.isFlammable());
        assertFalse(stock.isLiquid());
        assertTrue(stock.isPerishable());
        assertEquals("2025/12/31", stock.getExpirationDate());
    }

    @Test
    void testConstructorWithMultipleQualities() {
        // Item that is both liquid AND perishable (like milk)
        Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.LIQUID);
        qualities.add(SpecialQuality.PERISHABLE);
        
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        
        assertTrue(stock.getHasSpecialQualities());
        assertFalse(stock.isFlammable());
        assertTrue(stock.isLiquid());
        assertTrue(stock.isPerishable());
        assertEquals("2025/11/15", stock.getExpirationDate());
    }

    @Test
    void testConstructorWithAllThreeQualities() {
        // Hypothetical item with all three qualities
        Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.FLAMMABLE);
        qualities.add(SpecialQuality.LIQUID);
        qualities.add(SpecialQuality.PERISHABLE);
        
        Stock stock = new Stock(2, qualities, "juice", "usable", "12/12/2025");
        
        assertTrue(stock.getHasSpecialQualities());
        assertTrue(stock.isFlammable());
        assertTrue(stock.isLiquid());
        assertTrue(stock.isPerishable());
        assertEquals("2025/12/01", stock.getExpirationDate());
    }

}
