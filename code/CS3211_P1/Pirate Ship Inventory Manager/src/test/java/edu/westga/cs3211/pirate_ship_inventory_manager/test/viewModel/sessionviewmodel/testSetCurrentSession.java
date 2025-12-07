package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.sessionviewmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;

public class testSetCurrentSession {
	private ConcreteSessionViewModel viewModel;
	
	@BeforeEach
	void setup() {
		this.viewModel = new ConcreteSessionViewModel();

	}
	
	@Test
	void testWhenSessionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.viewModel.setCurrentSession(null);
		});
	}
	
	@Test
	void testWhenSessionValid() {
		var session = new CurrentSession(new User("Obi", "beens12", "Quartermaster"));
		this.viewModel.setCurrentSession(session);
		var actual = this.viewModel.getCurrentSession();
		assertEquals(session, actual.getValue());
	}
}
