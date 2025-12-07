package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.PickStorageWindowViewModel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.PickStorageWindowViewModel;

public class testConstructor {

	@Test
	void testValidConstructor() {
		assertDoesNotThrow(() -> {
			new PickStorageWindowViewModel();
		});
	}
}
