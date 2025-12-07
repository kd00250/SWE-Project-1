package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * The LandingPageWindowViewModel class.
 * 
 * @version Fall 2025
 * @author CS3211
 */
public class LandingPageWindowViewModel extends SessionViewModel {
	private ObjectProperty<String> role;

	/**
	 * Initializes a new LandingPageWindowViewModel
	 */
	public LandingPageWindowViewModel() {
		this.role = new SimpleObjectProperty<String>();
	}

	private void initializeProperties() {
		this.role.setValue(super.getCurrentSession().getValue().getUser().getRole());
	}

	@Override
	public void setCurrentSession(CurrentSession session) {
		super.setCurrentSession(session);
		this.initializeProperties();
	}

	/**
	 * Gets the current role property.
	 * 
	 * @return the role property.
	 */
	public ObjectProperty<String> roleProperty() {
		return this.role;
	}

}
