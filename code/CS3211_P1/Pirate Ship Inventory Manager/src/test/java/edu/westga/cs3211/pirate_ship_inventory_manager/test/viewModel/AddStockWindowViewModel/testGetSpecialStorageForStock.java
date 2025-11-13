package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testGetSpecialStorageForStock {

	@Test
	void testGetSpecialStorageAllNames() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.FLAMMABLE);
        qualities.add(SpecialQuality.LIQUID);
        qualities.add(SpecialQuality.PERISHABLE);
        Stock stock = new Stock(2, qualities, "juice", "usable", "2025/12/01");
		
		ArrayList<String> result = vm.getSpecialStorageForStock(stock);
		assertEquals(result.size(), 3); 
		assertEquals(result.get(0), "Flammable Storage");
		assertEquals(result.get(1), "Liquid Storage");
		assertEquals(result.get(2), "Perishable Storage");
	}
	
	@Test
	void testGetSpecialStorageFlammableNames() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.FLAMMABLE);
        Stock stock = new Stock(2, qualities, "juice", "usable", null);
		
		ArrayList<String> result = vm.getSpecialStorageForStock(stock);
		assertEquals(result.size(), 1);
		assertEquals(result.get(0), "Flammable Storage");
	}
	
	@Test
	void testGetSpecialStorageLiquidName() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.LIQUID);
        Stock stock = new Stock(2, qualities, "juice", "usable", null);
		
		ArrayList<String> result = vm.getSpecialStorageForStock(stock);
		assertEquals(result.size(), 1);
		assertEquals(result.get(0), "Liquid Storage");
	}
	
	@Test
	void testGetSpecialStoragePerishableName() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Set<SpecialQuality> qualities = new HashSet<>();
        qualities.add(SpecialQuality.PERISHABLE);
        Stock stock = new Stock(2, qualities, "juice", "usable", "12/12/2025");
		
		ArrayList<String> result = vm.getSpecialStorageForStock(stock);
		assertEquals(result.size(), 1);
		assertEquals(result.get(0), "Perishable Storage");
	}

}
