package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.inventorymanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;

class testGetInstance {

	@Test
	public void testGetInstanceReturnsNonNull() {
		InventoryManager manager = InventoryManager.getInstance();
		
		assertNotNull(manager, "getInstance should return a non-null instance");
	}
	
	/**
	 * Test that getInstance returns the same instance on multiple calls (Singleton pattern)
	 * 
	 * @precondition none
	 * @postcondition multiple calls to getInstance() return the exact same object
	 */
	@Test
	public void testGetInstanceReturnsSameInstance() {
		InventoryManager manager1 = InventoryManager.getInstance();
		InventoryManager manager2 = InventoryManager.getInstance(); 
		
		assertSame(manager1, manager2, "getInstance should return the same instance on multiple calls");
		assertEquals(5, manager1.getInventory().getCompartments().size());
		assertEquals(5, manager2.getInventory().getCompartments().size());
	}

}
