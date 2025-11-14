package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testSpecialStorageHasFreeSpace {

	@Test
	void testSpecialStorageHasFreeSpaceTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
	
		
		assertTrue(vm.specialStorageHasFreeSpace(vm.createStock()));
	}
	
	@Test
	void testSpecialStorageMultipleQuanitiesHasFreeSpaceFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Inventory inventory = InventoryManager.getInstance().getInventory();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true); 
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("25");
		inventory.getCompartments().get(0).addStock(vm.createStock());
		vm.getQuantity().set("26");
	
		
		assertFalse(vm.specialStorageHasFreeSpace(vm.createStock()));
	}
	
	@Test
	void testSpecialStorageMultipleQualitiesHasFreeSpaceTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Inventory inventory = InventoryManager.getInstance().getInventory();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("24");
		inventory.getCompartments().get(1).addStock(vm.createStock());
	
		
		assertTrue(vm.specialStorageHasFreeSpace(vm.createStock()));
	}
	
	@Test
	void testSpecialStorageMultipleQualitiesHasFreeSpaceFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("26");
	
		
		assertFalse(vm.specialStorageHasFreeSpace(vm.createStock()));
	}

}
