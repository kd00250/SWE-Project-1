package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.session.currentsession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;

public class testSetUser {

	@Test
	void testSettingValidUser() {
		var user = new User("Obi", "beens12", "Quartermaster");
		var session = new CurrentSession(user);
		
		var newUser = new User("Ada", "lovelace1234", "Quartermaster");
		session.setUser(newUser);
		assertEquals(newUser, session.getUser());
		
	}
	
	@Test
	void testSettingNullUser() {
		var user = new User("Obi", "beens12", "Quartermaster");
		var session = new CurrentSession(user);
		assertThrows(IllegalArgumentException.class, () -> {
			session.setUser(null);
		});
	}
}
