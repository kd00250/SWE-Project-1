package edu.westga.cs1302.javafx_sample.model;

import java.util.ArrayList;

/**
 * The UserStore class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class UserStore {
	private ArrayList<User> userList;
	
	/**
	 * initializes a new instance of UserStore
	 */
	public UserStore() {
		this.userList = new ArrayList<User>();
		User crewmate = new User("PirateBob", "password123", "Crewmate");
		User quartermaster = new User("Obi", "beens12", "Quartermaster");
		this.userList.add(crewmate);
		this.userList.add(quartermaster);
	}
	
	/**
	 * Gets the list of users
	 * 
	 * @return the list of users
	 */
	public ArrayList<User> getUserList() {
		return this.userList;
	}
	
	/**
	 * Gets the matching user from the userList
	 * 
	 * @param user the user that is being searched for
	 * @return the matching user from the userList
	 */
	public User getUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("user cannot be null");
		}
		User match = null;
		for (User currentUser : this.userList) {
			if (user.equals(currentUser)) {
				match = currentUser;
			}
		}
		return match;
	}
	
}
