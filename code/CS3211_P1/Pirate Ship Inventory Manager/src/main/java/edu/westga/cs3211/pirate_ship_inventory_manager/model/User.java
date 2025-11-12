package edu.westga.cs3211.pirate_ship_inventory_manager.model;

/**
 * The user class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class User {
	private String username;
	private String password;
	private String role;
	
	/**
	 * Creates a new instance of user
	 * 
	 * @precondition username != null || !username.isEmpty() || !username.isBlank() || 
	 * 				password != null || !password.isEmpty() || !password.isBlank()
	 * 				role != null || !role.isEmpty() || !role.isBlank()
	 * @postcondition none
	 * 
	 * @param username    the username of the user
	 * @param password    the password of the user
	 * @param role 		  the role of the user
	 */
	public User(String username, String password, String role) {
		if (username == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		if (password == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		if (username.isEmpty() || username.isBlank()) {
			throw new IllegalArgumentException("Username cannot be empty");
		}
		if (password.isEmpty() || password.isBlank()) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		if (role == null) {
			throw new IllegalArgumentException("Role cannot be null");
		}
		if (role.isEmpty() || role.isBlank()) {
			throw new IllegalArgumentException("Role cannot be empty");
		}
		
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	/**
	 * Gets the username of the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return username the username of the user
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Gets the password of the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return password the password of the user
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Gets the role of the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return role the role of the user
	 */
	public String getRole() {
		return this.role;
	}
}
