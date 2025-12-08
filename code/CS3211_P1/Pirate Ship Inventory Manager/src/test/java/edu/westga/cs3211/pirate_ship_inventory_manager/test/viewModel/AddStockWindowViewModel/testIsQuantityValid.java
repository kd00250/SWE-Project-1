package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testIsQuantityValid {

	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
    }
	
	@Test
	void testValidStock() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getStockQuantity().set(1);
	
		assertTrue(vm.isQuantityValid());
	}
	
	@Test
	void testZeroStockQuantity() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getStockQuantity().set(0);
	
		assertFalse(vm.isQuantityValid());
	}
	
	@Test
	void testNoStockQuantity() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		
		assertFalse(vm.isQuantityValid());
	}
	
	@Test
	void testMaxIntegerStockQuantity() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getStockQuantity().set(2147483647);
		
		assertTrue(vm.isQuantityValid());
	}
}