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

class testGetSpecialQuantityFilter {

	@BeforeEach
    void setUp() {
        LogManager.resetInstance();
    }
	
	@Test
	void testGetFlammableFilter() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.FLAMMABLE);
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/13/2029");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.addLogChange(change);
		
		
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).size(), 1);
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).get(0), change.getDisplayString());
	}
	
	@Test
	void testGetFlammableFilterNone() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).size(), 0);
		assertTrue(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).isEmpty());
	}
	
	@Test
	void testGetPerishableFilter() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(true);
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/13/2029");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
        inventory.addLogChange(change);
		
		
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).size(), 1);
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).get(0), change.getDisplayString());
	}
	
	@Test
	void testGetPerishableFilterNone() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(true);
		
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).size(), 0);
		assertTrue(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).isEmpty());
	}
	
	@Test
	void testGetLiquidFilter() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
		
		
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).size(), 1);
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).get(0), inventory.getLogChanges().get(1).getDisplayString());
	}
	
	@Test
	void testGetLiquidFilterNone() {
		ReviewStockChangesViewModel vm = new ReviewStockChangesViewModel();
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		LogChangesInventory inventory = LogManager.getInstance().getLogChangesInventory();
		inventory.getLogChanges().remove(1);
		User user = new User("bill", "nye", "Crewmate");
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.PERISHABLE);
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/13/2029");
        Inventory stockInventory = InventoryManager.getInstance().getInventory();
        LogChange change = new LogChange(user, stock, stockInventory.getCompartments().get(0)); 
        inventory.addLogChange(change);
		
		
		assertEquals(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).size(), 0);
		assertTrue(vm.getSpecialQuantityFilter(vm.getIsFlammableProperty().get(), 
				vm.getIsLiquidProperty().get(), vm.getIsPerishableProperty().get()).isEmpty());
	}

}
