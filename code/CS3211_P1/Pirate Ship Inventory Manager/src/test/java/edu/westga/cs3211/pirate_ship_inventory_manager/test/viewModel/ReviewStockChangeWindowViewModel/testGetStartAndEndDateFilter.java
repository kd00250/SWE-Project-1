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

class testGetStartAndEndDateFilter {

	@BeforeEach
    void setUp() {
        LogManager.resetInstance();
    }
	
	@Test
	void testGetStartAndEndFilter() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getEndDate().set("12/12/2029");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).get(0), change.getDisplayString());
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).size(), 1);
	}
	
	@Test
	void testGetStartAndEndFilterEqualsStartDate() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getEndDate().set("12/12/2029");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        change.setDate("12/11/2024");
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).get(0), change.getDisplayString());
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).size(), 1);
	}
	
	@Test
	void testGetStartAndEndFilterEqualsEndDate() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getEndDate().set("12/12/2029");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2029");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        change.setDate("12/12/2029");
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).get(0), change.getDisplayString());
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).size(), 1);
	}
	
	@Test
	void testGetStartAndEndFilterBeforeStartDate() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2029");
		vm.getEndDate().set("12/12/2029");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/13/2029");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.addLogChange(change);
        
        assertTrue(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).isEmpty());
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).size(), 0);
	}
	
	@Test
	void testGetStartAndEndFilterAfterEndDate() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2029");
		vm.getEndDate().set("12/12/2029");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/13/2029");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        change.setDate("12/13/2029");
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.addLogChange(change);
        
        assertTrue(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).isEmpty());
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).size(), 0);
	}
	
	@Test
	void testGetStartAndEndFilterNone() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getEndDate().set("12/12/2029");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2004");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        change.setDate("12/12/2004");
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertTrue(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).isEmpty());
        assertEquals(vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get()).size(), 0);
	}
	
	@Test
	void testGetStartAndEndFilterInvalid() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("aaa");
		vm.getEndDate().set("aaa");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2004");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.addLogChange(change);
        
        assertThrows(IllegalArgumentException.class, () -> {
			vm.getStartAndEndDateFilter(vm.getStartDate().get(), vm.getEndDate().get());
		});
	}

}
