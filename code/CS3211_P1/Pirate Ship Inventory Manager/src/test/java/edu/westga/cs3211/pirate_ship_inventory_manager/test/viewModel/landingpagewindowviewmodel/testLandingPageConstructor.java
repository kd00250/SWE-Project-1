package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.landingpagewindowviewmodel;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LandingPageWindowViewModel;

public class testLandingPageConstructor {
	@Test
	void testConstructorInitializesCorrectly() {
		var landingPage = new LandingPageWindowViewModel();
		assertNotNull(landingPage.roleProperty());
	}
}
