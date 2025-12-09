package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.InventoryPageWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.InventoryPageWindowViewModel;

class testIsQuantityToTakeValid {

	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
        LogManager.resetInstance();
    }
	
	@Test
	void testNullStock() {
		var vm = new InventoryPageWindowViewModel();
		//Is true by default, set to false to confirm if changed.
		vm.getShouldDisableTakeStock().set(false);
		vm.isQuantityToTakeValid();
		
		assertTrue(vm.getShouldDisableTakeStock().get());
	}
	
	@Test
	void testZeroQuantityToTake() {
		var vm = new InventoryPageWindowViewModel();
		vm.getShouldDisableTakeStock().set(false);
		Set<SpecialQuality> qualities = new HashSet<>();
        var stock = new Stock(1, qualities, "Paper","perfect", null);
		vm.getSelectedStock().set(stock);
		vm.getQuantityToTake().set(0);
		vm.isQuantityToTakeValid();
		
		assertTrue(vm.getShouldDisableTakeStock().get());
	}
	
	@Test
	void testQuantityToTakeGreaterThanStock() {
		var vm = new InventoryPageWindowViewModel();
		vm.getShouldDisableTakeStock().set(false);
		Set<SpecialQuality> qualities = new HashSet<>();
        var stock = new Stock(1, qualities, "Paper","perfect", null);
		vm.getSelectedStock().set(stock);
		vm.getQuantityToTake().set(2);
		vm.isQuantityToTakeValid();
		
		assertTrue(vm.getShouldDisableTakeStock().get());
	}
	
	@Test
	void testValidQuantityAndStock() {
		var vm = new InventoryPageWindowViewModel();
		vm.getShouldDisableTakeStock().set(true);
		Set<SpecialQuality> qualities = new HashSet<>();
        var stock = new Stock(1, qualities, "Paper","perfect", null);
		vm.getSelectedStock().set(stock);
		vm.getQuantityToTake().set(1);
		vm.isQuantityToTakeValid();
		
		assertFalse(vm.getShouldDisableTakeStock().get());
	}
}
