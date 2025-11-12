package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.UserStore;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The viewmodel the loginWindow of the application
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class LoginWindowViewModel {
	private UserStore store;
	private StringProperty username;
	private StringProperty password;
	private BooleanProperty  isQuartermaster;
	
	/**
	 * creates a new instance of loginWindowViewModel
	 */
	public LoginWindowViewModel() {
		this.username = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
		this.isQuartermaster = new SimpleBooleanProperty(false);
		this.store = new UserStore();
	}
	
	/**
	 * gets the username of the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the username of the user
	 */
	public StringProperty getUsername() {
		return this.username;
	}
	
	/**
	 * gets the password of the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the password of the user
	 */
	public StringProperty getPassword() {
		return this.password;
	}
	
	/**
	 * gets if the user is a quartermaster 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true/false depending on if the user is a quartermaster
	 */
	public BooleanProperty isQuartermasterProperty() {
		return this.isQuartermaster;
	}
	
	/**
	 * Checks to see if credentials are in the system
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true/false depending on if the credentials are in the system or not
	 */
	public boolean validateCredentials() {
		for (User currentUser : this.store.getUserList()) {
			if (currentUser.getUsername().equals(this.getUsername().get()) && currentUser.getPassword().equals(this.getPassword().get())) {
				if (currentUser.getRole().equals("Quartermaster")) {
					this.isQuartermaster.set(true);
				}
				return true;
			}
		}
		return false;
	}
}

