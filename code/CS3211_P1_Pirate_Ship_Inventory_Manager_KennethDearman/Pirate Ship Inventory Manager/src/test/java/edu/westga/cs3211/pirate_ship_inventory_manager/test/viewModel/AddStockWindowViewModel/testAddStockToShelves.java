package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testAddStockToShelves {

	@Test
	void testAddStockToShelvesTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		
		
		assertTrue(vm.addStockToShelves(vm.createStock()));
	}
	
	@Test
	void testAddStockToShelvesFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		
		
		assertFalse(vm.addStockToShelves(vm.createStock()));
	}

}
