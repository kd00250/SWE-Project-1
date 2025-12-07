package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class LandingPageWindowViewModel extends SessionViewModel {
	private ObjectProperty<String> role;
	
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
	
	public ObjectProperty<String> roleProperty() {
		return this.role;
	}
	
	
			
}
