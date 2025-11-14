package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testSpecialStorageHasFreeSpace {

	@Test
	void testSpecialStorageHasFreeSpaceTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
	
		
		assertTrue(vm.specialStorageHasFreeSpace(vm.createStock()));
	}
	
	@Test
	void testSpecialStorageHasFreeSpaceFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("26");
	
		
		assertFalse(vm.specialStorageHasFreeSpace(vm.createStock()));
	}

}
