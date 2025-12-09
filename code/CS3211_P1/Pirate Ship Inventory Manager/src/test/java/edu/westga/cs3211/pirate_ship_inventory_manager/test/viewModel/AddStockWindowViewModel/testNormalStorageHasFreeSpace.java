package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testNormalStorageHasFreeSpace {
	
	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
    }
	
	@Test
	void testNormalStorageHasFreeSpaceTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false); 
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
	
		
		assertTrue(vm.normalStorageHasFreeSpace(vm.createStock()));
	}
	
	@Test
	void testNormalStorageBoxesFullHasFreeSpaceTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Inventory inventory = InventoryManager.getInstance().getInventory();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false); 
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("27");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		inventory.getCompartments().get(0).addStock(vm.createStock());
	
		
		assertTrue(vm.normalStorageHasFreeSpace(vm.createStock()));
	}
	
	@Test
	void testNormalStorageHasFreeSpaceFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("35");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
	
		
		assertFalse(vm.normalStorageHasFreeSpace(vm.createStock()));
	}

}
