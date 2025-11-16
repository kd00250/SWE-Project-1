package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.ReviewStockChangeWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.ReviewStockChangesViewModel;

class testGetCrewList {

	@Test
	void testGetCrewListValid() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		
		assertEquals(vm.getCrewList().size(), 2);
		assertEquals(vm.getCrewList().get(0), "PirateBob");
		assertEquals(vm.getCrewList().get(1), "Obi");
	}

}
