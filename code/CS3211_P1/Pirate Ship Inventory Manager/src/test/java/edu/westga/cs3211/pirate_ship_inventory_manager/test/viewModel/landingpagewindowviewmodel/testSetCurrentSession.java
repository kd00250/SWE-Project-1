package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.landingpagewindowviewmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LandingPageWindowViewModel;

public class testSetCurrentSession {
	@Test
	void testSettingNullSession() {
		var landingPageVM = new LandingPageWindowViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			landingPageVM.setCurrentSession(null);
		});
	}
	
	@Test
	void testSettingSessionWhenValid() {
		var role = "Quartermaster";
		var session = new CurrentSession(new User("Obi", "beens12", role));
		var landingPageVM = new LandingPageWindowViewModel();
		landingPageVM.setCurrentSession(session);
		var actualRole = landingPageVM.roleProperty().getValue();
		assertEquals(session, landingPageVM.getCurrentSession().getValue());
		assertEquals(role, actualRole);
	}
}
