package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testGetSpecialStorage {

	@Test
	void testGetNormalStorageNames() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		
		ArrayList<String> result = vm.getSpecialStorage();
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "Special Storage 1");
		assertEquals(result.get(1), "Special Storage 2");
	}

}
