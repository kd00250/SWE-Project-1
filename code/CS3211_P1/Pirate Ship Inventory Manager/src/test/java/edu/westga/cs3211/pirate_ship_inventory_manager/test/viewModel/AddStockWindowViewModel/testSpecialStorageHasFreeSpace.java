package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testSpecialStorageHasFreeSpace {
	
	@Test
	void testFlammableStorageHasSpace() {
	    AddStockWindowViewModel vm = new AddStockWindowViewModel();
	    Set<SpecialQuality> qualities = new HashSet<>();
	    qualities.add(SpecialQuality.FLAMMABLE);
	    Stock stock = new Stock(5, qualities, "Gasoline", "good", "12/12/2025");
	    
	    assertTrue(vm.specialStorageHasFreeSpace(stock));
	}

	@Test
	void testFlammableStorageNoSpace() {
	    AddStockWindowViewModel vm = new AddStockWindowViewModel();
	    Set<SpecialQuality> qualities = new HashSet<>();
	    qualities.add(SpecialQuality.FLAMMABLE);
	    Stock bigStock = new Stock(100, qualities, "Gasoline", "good", "12/12/2025"); // Assuming capacity is less than 100
	    
	    assertFalse(vm.specialStorageHasFreeSpace(bigStock));
	}

	@Test
	void testLiquidStorageHasSpace() {
	    AddStockWindowViewModel vm = new AddStockWindowViewModel();
	    Set<SpecialQuality> qualities = new HashSet<>();
	    qualities.add(SpecialQuality.LIQUID);
	    Stock stock = new Stock(5, qualities, "Water", "good", "12/12/2025");
	    
	    assertTrue(vm.specialStorageHasFreeSpace(stock));
	}

	@Test
	void testLiquidStorageNoSpace() {
	    AddStockWindowViewModel vm = new AddStockWindowViewModel();
	    Set<SpecialQuality> qualities = new HashSet<>();
	    qualities.add(SpecialQuality.LIQUID);
	    Stock bigStock = new Stock(100, qualities, "Water", "good", "12/12/2025");
	    
	    assertFalse(vm.specialStorageHasFreeSpace(bigStock));
	}

	@Test
	void testPerishableStorageHasSpace() {
	    AddStockWindowViewModel vm = new AddStockWindowViewModel();
	    Set<SpecialQuality> qualities = new HashSet<>();
	    qualities.add(SpecialQuality.PERISHABLE);
	    Stock stock = new Stock(5, qualities, "Milk", "good", "12/12/2025");
	    
	    assertTrue(vm.specialStorageHasFreeSpace(stock));
	}

	@Test
	void testPerishableStorageNoSpace() {
	    AddStockWindowViewModel vm = new AddStockWindowViewModel();
	    Set<SpecialQuality> qualities = new HashSet<>();
	    qualities.add(SpecialQuality.PERISHABLE);
	    Stock bigStock = new Stock(100, qualities, "Milk", "good", "12/12/2025");
	    
	    assertFalse(vm.specialStorageHasFreeSpace(bigStock));
	}

	@Test
	void testNoSpecialStorageNeeded() {
	    AddStockWindowViewModel vm = new AddStockWindowViewModel();
	    Set<SpecialQuality> qualities = new HashSet<>();
	    Stock stock = new Stock(5, qualities, "Paper", "good", "12/12/2025");
	    
	    assertFalse(vm.specialStorageHasFreeSpace(stock));
	}

}
