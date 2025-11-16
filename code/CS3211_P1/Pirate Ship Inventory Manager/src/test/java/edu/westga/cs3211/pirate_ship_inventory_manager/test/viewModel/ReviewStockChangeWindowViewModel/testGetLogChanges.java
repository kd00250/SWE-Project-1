package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.ReviewStockChangeWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.ReviewStockChangesViewModel;

class testGetLogChanges {

	@Test
	void testGetLogChangesList() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		LogChangesInventory logChanges = LogManager.getInstance().getLogChangesInventory();
		
		assertEquals(vm.getLogChanges().size(), 2);
		assertEquals(vm.getLogChanges().get(0), logChanges.getLogChanges().get(1).getDisplayString());
		assertEquals(vm.getLogChanges().get(1), logChanges.getLogChanges().get(0).getDisplayString());
	}

}
