package edu.westga.cs1302.javafx_sample.test.model.userstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample.model.User;
import edu.westga.cs1302.javafx_sample.model.UserStore;

class testConstructor {

	@Test
	public void testValidConstructor() {
		UserStore store = new UserStore();
		User crewmate = new User("PirateBob", "password123", "Crewmate");
		User quartermaster = new User("Obi", "beens12", "Quartermaster");
		
		assertEquals(store.getUserList().get(0).getUsername(), crewmate.getUsername());
		assertEquals(store.getUserList().get(0).getPassword(), crewmate.getPassword());
		assertEquals(store.getUserList().get(0).getRole(), crewmate.getRole());
		assertEquals(store.getUserList().get(1).getUsername(), quartermaster.getUsername());
		assertEquals(store.getUserList().get(1).getPassword(), quartermaster.getPassword());
		assertEquals(store.getUserList().get(1).getRole(), quartermaster.getRole());
	}

}
