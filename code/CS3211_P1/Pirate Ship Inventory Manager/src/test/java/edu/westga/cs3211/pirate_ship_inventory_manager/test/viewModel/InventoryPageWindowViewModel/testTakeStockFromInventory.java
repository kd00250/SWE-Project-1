package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.InventoryPageWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.InventoryPageWindowViewModel;

class testTakeStockFromInventory {

	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
        LogManager.resetInstance();
    }
	
	@Test
	void testValidStockWasTaken() {
		var vm = new InventoryPageWindowViewModel();
		vm.getStockTypeProperty().set(StockType.FOOD);
		var listOfStocks = vm.getStockInInventory();
		var stockToTake = listOfStocks.getFirst();
		vm.getSelectedStock().set(stockToTake);
		vm.getQuantityToTake().set(2);
		var user = new User("Duane", "LetsRockNRoll", "Cook");
		var result = vm.takeStockFromInventory(user);
		
		assertTrue(result);
	}

	@Test
	void testNoStockSelectedToBeTaken() {
		var vm = new InventoryPageWindowViewModel();
		vm.getStockTypeProperty().set(StockType.MUNITION);
		var user = new User("Duane", "LetsRockNRoll", "Cook");
		var result = vm.takeStockFromInventory(user);
		
		assertFalse(result);
	}
	
	@Test
	void testTooMuchSelectedToBeTaken() {
		var vm = new InventoryPageWindowViewModel();
		vm.getStockTypeProperty().set(StockType.FOOD);
		var listOfStocks = vm.getStockInInventory();
		var stockToTake = listOfStocks.getFirst();
		vm.getSelectedStock().set(stockToTake);
		vm.getQuantityToTake().set(3);
		var user = new User("Duane", "LetsRockNRoll", "Cook");
		var result = vm.takeStockFromInventory(user);
		
		assertFalse(result);
	}
}
