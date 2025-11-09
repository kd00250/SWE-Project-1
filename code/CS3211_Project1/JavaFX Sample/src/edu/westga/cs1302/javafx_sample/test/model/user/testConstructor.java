package edu.westga.cs1302.javafx_sample.test.model.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample.model.User;

class testConstructor {

	@Test
	public void testUsernameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User(null, "bill", "Crewmate");
		});
	}
	
	@Test
	public void testUsernameBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User("", "bill", "Crewmate");
		});
	}
	
	@Test
	public void testUsernameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User(" ", "bill", "Crewmate");
		});
	}
	
	@Test
	public void testPasswordNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User("bill", null, "Crewmate");
		});
	}
	
	@Test
	public void testPasswordBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User("bill", "", "Crewmate");
		});
	}
	
	@Test
	public void testPasswordIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User("bill", " ", "Crewmate");
		});
	}
	
	@Test
	public void testRoleNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User("bill", "nye", null);
		});
	}
	
	@Test
	public void testRoleBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User("bill", "nye", "");
		});
	}
	
	@Test
	public void testRoleIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new User("bill", "nye", " ");
		});
	}
	
	@Test
	public void testValidConstructor() {
		User user = new User("bill", "nye", "CrewMate");
		assertEquals("bill", user.getUsername());
		assertEquals("nye", user.getPassword());
		assertEquals("CrewMate", user.getRole());
	}

}
