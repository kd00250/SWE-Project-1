package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.session.currentsession;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;

public class testGetUser {
	@Test
	void testGettingUser() {
		var user = new User("Obi", "beens12", "Quartermaster");
		var session = new CurrentSession(user);
		var actual = session.getUser();
		assertEquals(user, actual);
	}
}
