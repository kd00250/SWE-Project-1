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

class testGetStartAndEndTimeChanges {

	@BeforeEach
    void setUp() {
        LogManager.resetInstance();
    }
	
	@Test
	void testGetStartAndEndFilterHours() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getHoursStartDate().set("10");
		vm.getHoursEndDate().set("11");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        change.setTime("10:00:00");
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        String startTimeValues = vm.getHoursStartDate().get() + "," + "" + "," + "";
        String endTimeValues = vm.getHoursEndDate().get() + "," + "" + "," + "";
        
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).get(0), change.getDisplayString());
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).size(), 1);
	}
	
	@Test
	void testGetStartAndEndFilterMinutes() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getMinutesStartDate().set("10");
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
        String startTimeValues = "" + "," + vm.getMinutesStartDate().get() + "," + "";
        String endTimeValues = "" + "," + vm.getMinutesEndDate().get() + "," + "";
        
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).get(0), change.getDisplayString());
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).size(), 1);
	}
	
	@Test
	void testGetStartFilterSeconds() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getSecondsStartDate().set("30");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        change.setTime("00:00:30");
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        String startTimeValues = "" + "," + "" + "," + vm.getSecondsStartDate().get();
        String endTimeValues = "" + "," + "" + "," + "";
        
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).get(0), change.getDisplayString());
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).size(), 1);
	}
	
	@Test
	void testGetStartFilterAllPresent() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		vm.getHoursStartDate().set("10");
		vm.getMinutesStartDate().set("01");
		vm.getSecondsStartDate().set("30");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        change.setTime("10:01:30");
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        String startTimeValues = vm.getHoursStartDate().get() + "," + vm.getMinutesStartDate().get() + "," + vm.getSecondsStartDate().get();
        String endTimeValues = "" + "," + "" + "," + "";
        
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).get(0), change.getDisplayString());
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).size(), 1);
	}
	
	@Test
	void testGetStartFilterNoneUnderStart() {
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
        String startTimeValues = "11" + "," + "" + "," + "";
        String endTimeValues = "12" + "," + "" + "," + "";
        
        assertTrue(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).isEmpty());
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).size(), 0);
	}
	
	@Test
	void testGetStartFilterNoneOverEnd() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getStartDate().set("12/11/2024");
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        change.setTime("20:01:30");
        inventory.getLogChanges().clear();
        inventory.addLogChange(change);
        String startTimeValues = "11" + "," + "" + "," + "";
        String endTimeValues = "12" + "," + "" + "," + "";
        
        assertTrue(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).isEmpty());
        assertEquals(vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues).size(), 0);
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
	    String startTimeValues = "aaa" + "," + "" + "," + "";
        String endTimeValues = "12" + "," + "" + "," + "";
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues);
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
	    String startTimeValues = "aaa" + "," + "" + "," + "";
        String endTimeValues = "12" + "," + "" + "," + "";
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	    	vm.getStartAndEndTimeChanges(vm.getStartDateFilterForTime(vm.getStartDate().get()), startTimeValues, endTimeValues);
	    });
	}

}
