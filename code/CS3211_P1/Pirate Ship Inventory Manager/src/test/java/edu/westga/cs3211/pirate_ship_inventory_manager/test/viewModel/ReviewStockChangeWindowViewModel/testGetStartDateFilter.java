package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.ReviewStockChangeWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.ReviewStockChangesViewModel;

class testGetStartDateFilter {

	@BeforeEach
    void setUp() {
        LogManager.resetInstance();
    }
	
	@Test
	void testGetStartFilter() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertEquals(vm.getStartDateFilter(vm.getStartDate().get()).get(0), change.getDisplayString());
        assertEquals(vm.getStartDateFilter(vm.getStartDate().get()).size(), 1);
	}
	
	@Test
	void testGetStartFilterNone() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2030");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2004");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.addLogChange(change);
        
        assertTrue(vm.getStartDateFilter(vm.getStartDate().get()).isEmpty());
        assertEquals(vm.getStartDateFilter(vm.getStartDate().get()).size(), 0);
	}
	
	@Test
	void testGetStartFilterNoneWrongFormat() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("aaaa");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2004");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.addLogChange(change);
        
        assertThrows(IllegalArgumentException.class, () -> {
			vm.getStartDateFilter(vm.getStartDate().get());
		});
	}

}
