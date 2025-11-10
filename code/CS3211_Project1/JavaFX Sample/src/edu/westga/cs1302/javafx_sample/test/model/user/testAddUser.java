package edu.westga.cs1302.javafx_sample.test.model.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample.model.Inventory;
import edu.westga.cs1302.javafx_sample.model.User;
import edu.westga.cs1302.javafx_sample.model.UserStore;

class testAddUser {

	@Test
	void testAddNullStock() {
		UserStore store = new UserStore();
		assertThrows(IllegalArgumentException.class, () -> {
			store.addUser(null);
		});
	}
	
	@Test
	void testAddValidStock() {
		UserStore store = new UserStore();
		User user = new User("bill", "bob", "Crewmate");
		store.addUser(user);
		
		assertEquals(user.getUsername(), store.getUserList().get(2).getUsername());
		assertEquals(user.getPassword(), store.getUserList().get(2).getPassword());
		assertEquals(user.getRole(), store.getUserList().get(2).getRole());	
	}

}
