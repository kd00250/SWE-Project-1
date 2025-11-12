package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.userstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.UserStore;

class testGetUser {

	@Test
	public void testNullUser() {
		UserStore store = new UserStore();
		assertThrows(IllegalArgumentException.class, () -> {
			store.getUser(null);
		});
	}
	
	@Test
	public void testgetMatchingUser() {
		User user = new User("bill", "nye", "CrewMate");
		UserStore store = new UserStore();
		store.getUserList().add(user);
		User result = store.getUser(user);
		
		assertEquals("bill", result.getUsername());
		assertEquals("nye", result.getPassword());
		assertEquals("CrewMate", result.getRole());
	}
	
	@Test
	public void testgetMatchingUserNoMatch() {
		User user = new User("bill", "nye", "CrewMate");
		UserStore store = new UserStore();
		User result = store.getUser(user);
		
		assertEquals(null, result);
	}

}
