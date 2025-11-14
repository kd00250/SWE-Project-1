package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testGetNormalStorage {

	@Test
	void testGetNormalStorageNames() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		Set<SpecialQuality> qualities = new HashSet<>();
        
        Stock stock = new Stock(5, qualities, "Milk", "perfect", null);
		ArrayList<String> result = vm.getNormalStorage(stock);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "Boxes");
		assertEquals(result.get(1), "Shelves");
	}

}
