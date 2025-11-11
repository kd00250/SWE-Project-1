package edu.westga.cs3211.swe_project1.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.swe_project1.viewModel.AddStockWindowViewModel;

class testAddStockToSpecialStorage1 {

	@Test
	void testAddStockToSpecialStorage1True() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		
		
		assertTrue(vm.addStockToSpecialStorage1(vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage1False() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		//vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		
		
		assertFalse(vm.addStockToSpecialStorage1(vm.createStock()));
	}

}
