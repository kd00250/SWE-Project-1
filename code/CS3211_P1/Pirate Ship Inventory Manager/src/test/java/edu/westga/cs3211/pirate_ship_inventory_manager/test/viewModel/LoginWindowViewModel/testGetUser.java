package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.LoginWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.UserStore;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;

class testGetUser {

	@Test
	public void testCrewMateCredentials() {
		LoginWindowViewModel vm = new LoginWindowViewModel();
		UserStore store = new UserStore();
		vm.getUsername().set("PirateBob");
		vm.getPassword().set("password123");
		
		vm.validateCredentials();
		
		assertEquals(store.getUserList().get(0).getUsername(), vm.getUser().getUsername());
		assertEquals(store.getUserList().get(0).getPassword(), vm.getUser().getPassword());
		assertEquals(store.getUserList().get(0).getRole(), vm.getUser().getRole());
	}
	
	@Test
	public void testQuarterMasterCredentials() {
		LoginWindowViewModel vm = new LoginWindowViewModel();
		UserStore store = new UserStore();
		vm.getUsername().set("Obi");
		vm.getPassword().set("beens12");
		
		vm.validateCredentials();
		
		assertTrue(vm.isQuartermasterProperty().get());
		assertEquals(store.getUserList().get(1).getUsername(), vm.getUser().getUsername());
		assertEquals(store.getUserList().get(1).getPassword(), vm.getUser().getPassword());
		assertEquals(store.getUserList().get(1).getRole(), vm.getUser().getRole());
	}
	
	@Test
	public void testInvalidCredentialsUserNull() {
		LoginWindowViewModel vm = new LoginWindowViewModel();
		vm.getUsername().set("Kobe");
		vm.getPassword().set("beens12");
		
		vm.validateCredentials();
		
		assertEquals(null, vm.getUser());
	}

}
