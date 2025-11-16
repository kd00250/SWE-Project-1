package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.ReviewStockChangeWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.ReviewStockChangesViewModel;

class testGetCrewmatesFilter {

	@Test
	void testGetCrewmateFilterPirateBob() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		LogChangesInventory logChanges = LogManager.getInstance().getLogChangesInventory();
		ArrayList<String> names = new ArrayList<String>();
		names.add("PirateBob");
		
		assertEquals(vm.getCrewmateFilter(names).size(), 2);
		assertEquals(vm.getCrewmateFilter(names).get(0), logChanges.getLogChanges().get(0).getDisplayString());
		assertEquals(vm.getCrewmateFilter(names).get(1), logChanges.getLogChanges().get(1).getDisplayString());
	}
	
	@Test
	void testGetCrewmateFilterObi() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		ArrayList<String> names = new ArrayList<String>();
		names.add("Obi");
		
		assertEquals(vm.getCrewmateFilter(names).size(), 0);
		assertTrue(vm.getCrewmateFilter(names).isEmpty());
	}

}
