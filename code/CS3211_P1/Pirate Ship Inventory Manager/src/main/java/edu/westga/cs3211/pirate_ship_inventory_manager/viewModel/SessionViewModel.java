package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.beans.property.ObjectProperty;

public abstract class SessionViewModel {
	private ObjectProperty<CurrentSession> session;
	
	public ObjectProperty<CurrentSession> getCurrentSession() {
		return this.session;
	}
	
	public void setCurrentSession(CurrentSession session) {
		this.session.set(session);
	}
}
