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

class testGetStartTimeChangesForEndTime {

	@BeforeEach
    void setUp() {
        LogManager.resetInstance();
    }
	
	@Test
	void testGetStartFilterHours() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getHoursEndDate().set("10");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        change.setTime("10:00:00");
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertEquals(vm.getStartTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), vm.getHoursEndDate().get(), "", "").get(0), change.getDisplayString());
        assertEquals(vm.getStartTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), vm.getHoursEndDate().get(), "", "").size(), 1);
	}
	
	@Test
	void testGetStartFilterMinutes() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getMinutesEndDate().set("10");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        change.setTime("00:10:00");
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertEquals(vm.getStartTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), "", vm.getMinutesEndDate().get(), "").get(0), change.getDisplayString());
        assertEquals(vm.getStartTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), "", vm.getMinutesEndDate().get(), "").size(), 1);
	}
	
	@Test
	void testGetStartFilterSeconds() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getSecondsEndDate().set("30");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        change.setTime("00:00:30");
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        
        assertEquals(vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), "", "", vm.getSecondsEndDate().get()).get(0), change.getDisplayString());
        assertEquals(vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), "", "", vm.getSecondsEndDate().get()).size(), 1);
	}
	
	@Test
	void testGetStartFilterAllPresent() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getHoursEndDate().set("10");
		vm.getMinutesEndDate().set("01");
		vm.getSecondsEndDate().set("30");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        change.setTime("10:00:30");
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);

        assertEquals(vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), vm.getHoursEndDate().get(), vm.getMinutesEndDate().get(), vm.getSecondsEndDate().get()).get(0), change.getDisplayString());
        assertEquals(vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), vm.getHoursEndDate().get(), vm.getMinutesEndDate().get(), vm.getSecondsEndDate().get()).size(), 1);
	}
	
	@Test
	void testGetStartFilterNone() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        change.setTime("10:01:30");
        inventory.getLogChanges().clear();
        inventory.addLogChange(change); 

        assertTrue(vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), "9", "", "").isEmpty());
        assertEquals(vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), "9", "", "").size(), 0);
	}
	
	@Test
	void testGetStartTimeChangesInvalidHours() {
	    ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
	    vm.getStartDate().set("12/11/2024");
	    
	    User user = new User("bill", "nye", "Crewmate");
	    Set<SpecialQuality> qualities = new HashSet<>();
	    Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
	    Inventory stockInventory = InventoryManager.getInstance().getInventory();
	    LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0));
	    change.setTime("10:01:30");
	    LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
	    inventory.getLogChanges().clear();
	    inventory.addLogChange(change);
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), "abc", "00", "00");
	    });
	}
	
	@Test
	void testGetStartTimeChangesInvalidTimeFormat() {
	    ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
	    vm.getStartDate().set("12/11/2024");
	    
	    User user = new User("bill", "nye", "Crewmate");
	    Set<SpecialQuality> qualities = new HashSet<>();
	    Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
	    Inventory stockInventory = InventoryManager.getInstance().getInventory();
	    LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0));
	    change.setTime("10:1:30");
	    LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
	    inventory.getLogChanges().clear();
	    inventory.addLogChange(change);
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        vm.getStartTimeChangesForEndTime(vm.getStartDateFilterForTime(vm.getStartDate().get()), "10", "00", "00");
	    });
	}

}
