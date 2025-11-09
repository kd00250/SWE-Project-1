package edu.westga.cs1302.javafx_sample.viewModel;

import edu.westga.cs1302.javafx_sample.model.User;
import edu.westga.cs1302.javafx_sample.model.UserStore;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The codebehind the loginWindow of the application
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class LoginWindowViewModel {
	private UserStore store;
	private StringProperty username;
	private StringProperty password;
	
	/**
	 * creates a new instance of loginWindowViewModel
	 */
	public LoginWindowViewModel() {
		this.username = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
		this.store = new UserStore();
	}
	
	/**
	 * gets the username of the user
	 * 
	 * @return the username of the user
	 */
	public StringProperty getUsername() {
		return this.username;
	}
	
	/**
	 * gets the password of the user
	 * 
	 * @return the password of the user
	 */
	public StringProperty getPassword() {
		return this.password;
	}
	
	/**
	 * Checks to see if credentials are in the system
	 * 
	 * @return true/false depending on if the credentials are in the system or not
	 */
	public boolean validateCredentials() {
		for (User currentUser : this.store.getUserList()) {
			if (currentUser.getUsername().equals(this.getUsername().get()) && currentUser.getPassword().equals(this.getPassword().get())) {
				return true;
			}
		}
		return false;
	}
}

