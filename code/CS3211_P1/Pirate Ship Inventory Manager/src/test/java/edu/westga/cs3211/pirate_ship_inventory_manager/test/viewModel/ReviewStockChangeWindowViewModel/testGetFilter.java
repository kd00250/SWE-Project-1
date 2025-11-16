package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.ReviewStockChangeWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.ReviewStockChangesViewModel;

class testGetFilter {

	@Test
	void testGetFilterSQ() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getFilter().set("Special Quantity");
		
		assertEquals(vm.getFilter().get(), "Special Quantity");
	}
	
	@Test
	void testGetFilterDate() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getFilter().set("Date");
		
		assertEquals(vm.getFilter().get(), "Date");
	}
	
	@Test
	void testGetFilterCrewmate() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getFilter().set("Crewmate");
		
		assertEquals(vm.getFilter().get(), "Crewmate");
	}

}
