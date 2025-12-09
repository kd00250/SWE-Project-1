package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.InventoryPageWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.InventoryPageWindowViewModel;

class testGetStockInInventory {

	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
        LogManager.resetInstance();
    }
	
	@Test
	void testGettingNonEmptyListOfStock() {
		var vm = new InventoryPageWindowViewModel();
		vm.getStockTypeProperty().set(StockType.MUNITION);
		var result = vm.getStockInInventory();
		
		assertTrue(result.isEmpty());
	}

}
