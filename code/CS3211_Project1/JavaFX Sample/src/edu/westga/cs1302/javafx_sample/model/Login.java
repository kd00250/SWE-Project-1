package edu.westga.cs1302.javafx_sample.model;

/**
 * The login class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class Login {
	private UserStore store;
	
	/**
	 * Creates a new instance of login
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Login() {
		this.store = store;
	}
	
	/**
	 * Checks if user credentials match the crewmate
	 * 
	 * @param username the username of the user
	 * @param password the password of the user
	 * 
	 * @return true/false depending on if the credentials match that of a crew mate in the system
	 */
	public boolean isUserCrewMate(String username, String password) {
		if (username == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		if (password == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		
		return username.equals(Credentials.CREWMATE_USERNAME.getValue()) && password.equals(Credentials.CREWMATE_PASSWORD.getValue());
	}
	
	/**
	 * Checks if user credentials mathc the quartermaster
	 * 
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return true/false depending on if the credentials match that of a quarter master in the system
	 */
	public boolean isUserQuarterMaster(String username, String password) {
		if (username == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		if (password == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		
		return username.equals(Credentials.QUARTERMASTER_USERNAME.getValue()) && password.equals(Credentials.QUARTERMASTER_PASSWORD.getValue());
	}
}
