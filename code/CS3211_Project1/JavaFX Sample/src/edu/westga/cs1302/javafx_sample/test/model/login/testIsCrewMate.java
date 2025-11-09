package edu.westga.cs1302.javafx_sample.test.model.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.javafx_sample.model.Login;

class testIsCrewMate {

	@Test
	public void testPasswordNull() {
		Login login = new Login();
		assertThrows(IllegalArgumentException.class, () -> {
			login.isUserCrewMate("bill", null);
		});
	}
	
	@Test
	public void testUsernameNull() {
		Login login = new Login();
		assertThrows(IllegalArgumentException.class, () -> {
			login.isUserCrewMate(null, "null");
		});
	}
	
	@Test
	public void testUserIsCrewMate() {
		Login login = new Login();
		
		assertTrue(login.isUserCrewMate("PirateBob", "password123"));
		
	}
	
//	@ParameterizedTest
//	@CsvSource( {"bill", "nye", "Obi", "Wan"})
//	public void testcomes(String username, String password) {
//		Random prediction = new Random(32);
//		HiLoGame game = new HiLoGame(prediction);
//		
//		String result = game.checkGuess(guess);
//		
//		assertEquals(guessMessage, result);
//	}


}
