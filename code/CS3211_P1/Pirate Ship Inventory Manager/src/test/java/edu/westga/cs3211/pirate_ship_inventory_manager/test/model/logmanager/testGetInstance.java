package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.logmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;

class testGetInstance {

	@Test
	public void testGetInstanceReturnsNonNull() {
		LogManager manager = LogManager.getInstance();
		
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
		LogManager manager1 = LogManager.getInstance();
		LogManager manager2 = LogManager.getInstance(); 
		
		assertSame(manager1, manager2, "getInstance should return the same instance on multiple calls");
		assertEquals(2, manager1.getLogChangesInventory().getLogChanges().size());
		assertEquals(2, manager2.getLogChangesInventory().getLogChanges().size());
	}

}
