package edu.westga.cs3211.swe_project1.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.swe_project1.viewModel.AddStockWindowViewModel;

class testAddStockToBoxes {

	@Test
	void testAddStockToBoxesTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		
		
		assertTrue(vm.addStockToBoxes(vm.createStock()));
	}
	
	@Test
	void testAddStockToBoxesFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		
		
		assertFalse(vm.addStockToBoxes(vm.createStock()));
	}

}
