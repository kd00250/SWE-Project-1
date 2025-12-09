package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.InventoryPageWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.InventoryPageWindowViewModel;

class testIsStockTypeInInventory {

	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
        LogManager.resetInstance();
    }
	
	@Test
	void testStockTypeIsInInventory() {
		var vm = new InventoryPageWindowViewModel();
		vm.getStockTypeProperty().set(StockType.FOOD);
		
		var result = vm.isStockTypeInInventory();
		
		assertTrue(result);
	}
	
	@Test
	void testStockTypeIsNotInInventory() {
		var vm = new InventoryPageWindowViewModel();
		vm.getStockTypeProperty().set(StockType.MUNITION);
		
		var result = vm.isStockTypeInInventory();
		
		assertFalse(result);
	}

}
