package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.InventoryPageWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.InventoryPageWindowViewModel;

class testGetSummaryMessage {
	
	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
        LogManager.resetInstance();
    }

	@Test
	void test() {
		var vm = new InventoryPageWindowViewModel();
		vm.getStockTypeProperty().set(StockType.FOOD);
		var listOfStocks = vm.getStockInInventory();
		var stockToTake = listOfStocks.getFirst();
		vm.getSelectedStock().set(stockToTake);
		vm.getQuantityToTake().set(2);
		var user = new User("Duane", "LetsRockNRoll", "Cook");
		var sizeBeforeStockRemoval = LogManager.getInstance().getLogChangesInventory().getLogChanges().size();
		LogChange logChangeBeforeStockRemoval = LogManager.getInstance().getLogChangesInventory().getLogChanges().getLast();
		vm.takeStockFromInventory(user);
		var resultMessage = vm.getSummaryMessage();
		var sizeAfterStockRemoval = LogManager.getInstance().getLogChangesInventory().getLogChanges().size();
		
		assertAll(
				() -> assertTrue(sizeAfterStockRemoval > sizeBeforeStockRemoval),
				() -> assertFalse(logChangeBeforeStockRemoval.toString().equals(resultMessage))
				);
	}

}
