package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * The SessionViewModel abstract class.
 * @version fall 2025
 * @author CS3211
 */
public abstract class SessionViewModel {
	private ObjectProperty<CurrentSession> session;

	protected SessionViewModel() {
		this.session = new SimpleObjectProperty<CurrentSession>();
	}

	/**
	 * Gets the current session property.
	 * @return the current session
	 */
	public ObjectProperty<CurrentSession> getCurrentSession() {
		return this.session;
	}

	/**
	 * Sets the current session.
	 * @param session the session.
	 */
	public void setCurrentSession(CurrentSession session) {
		if (session == null) {
			throw new IllegalArgumentException("Session cannot be null");
		}
		this.session.set(session);
	}

}
