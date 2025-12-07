package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class SessionViewModel {
	private ObjectProperty<CurrentSession> session;
	
	public ObjectProperty<CurrentSession> getCurrentSession() {
		return this.session;
	}
	
	protected SessionViewModel() {
		this.session = new SimpleObjectProperty<CurrentSession>();
	}
	
	public void setCurrentSession(CurrentSession session) {
		if (session == null) {
			throw new IllegalArgumentException("Session cannot be null");
		}
		this.session.set(session);
	}
	
}
