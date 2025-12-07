package edu.westga.cs3211.pirate_ship_inventory_manager.model.session;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;

/**
 * The CurrentSession class.
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class CurrentSession {
	private User user;

	/**
	 * Initializes a new session with a user.
	 * 
	 * @param user the user
	 */
	public CurrentSession(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		this.user = user;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the user.
	 * @param user the user
	 */
	public void setUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		this.user = user;
	}

}
