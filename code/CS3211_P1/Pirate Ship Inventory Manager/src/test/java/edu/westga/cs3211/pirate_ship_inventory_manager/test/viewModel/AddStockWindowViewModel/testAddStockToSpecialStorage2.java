package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testAddStockToSpecialStorage2 {

	@Test
	void testAddStockToSpecialStorage2True() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		
		
		assertTrue(vm.addStockToSpecialStorage2(vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage2True2Qualities() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		
		
		assertTrue(vm.addStockToSpecialStorage2(vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage2TrueAllQualities() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(true);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		
		
		assertTrue(vm.addStockToSpecialStorage2(vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage2False() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		
		
		assertFalse(vm.addStockToSpecialStorage2(vm.createStock()));
	}

}
