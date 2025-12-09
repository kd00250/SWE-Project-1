package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.session.currentsession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;

public class testCurrentSessionConstructor {

	@Test
	void testCurrentSessionWithValidUser() {
		var user = new User("Obi", "beens12", "Quartermaster");
		var session = new CurrentSession(user);
		assertEquals(user, session.getUser());
	}
	
	@Test
	void testCurrentSessionWithNullUser() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CurrentSession(null);
		});
	}
}
