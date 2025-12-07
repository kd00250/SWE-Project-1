package edu.westga.cs3211.pirate_ship_inventory_manager.model.session;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;

public class CurrentSession {
	private User user;
	public CurrentSession(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		this.user = user;
	}
	
	
}
