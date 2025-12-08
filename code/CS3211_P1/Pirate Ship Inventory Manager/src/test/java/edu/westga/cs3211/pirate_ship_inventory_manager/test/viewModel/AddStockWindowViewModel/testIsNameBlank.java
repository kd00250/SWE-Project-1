package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testIsNameBlank {

	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
    }
	
	@Test
	void testValidName() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getName().set("Gold");
	
		assertFalse(vm.isNameBlank());
	}
	
	@Test
	void testBlankName() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getName().set("");
	
		assertTrue(vm.isNameBlank());
	}
	
	@Test
	void testNameWithSpace() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getName().set(" ");
	
		assertTrue(vm.isNameBlank());
	}
}