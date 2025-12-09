package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.ReviewStockChangeWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.UserStore;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.ReviewStockChangesViewModel;

class testGetCrewmatesFilter {

	@BeforeEach
    void setUp() {
        LogManager.resetInstance();
    }
	
	@Test
	void testGetCrewmateFilterPirateBob() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		LogChangesInventory logChanges = LogManager.getInstance().getLogChangesInventory();
		ArrayList<String> names = new ArrayList<String>();
		logChanges.getLogChanges().clear();
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.LIQUID);
		Stock stock1 = new Stock(1, new HashSet<>(), "Paper", "perfect", null);
        Stock stock2 = new Stock(1, qualities, "Oil", "perfect", null);
        Compartment regular1 = new Compartment("Boxes", 30, false);
        Compartment special2 = new Compartment("Liquid Storage", 25, true);
        UserStore store = new UserStore();
        LogChange change1 = new LogChange(store.getUserList().get(0), stock1, regular1);
        LogChange change2 = new LogChange(store.getUserList().get(0), stock2, special2);
        logChanges.getLogChanges().add(change1);
        logChanges.getLogChanges().add(change2);
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
