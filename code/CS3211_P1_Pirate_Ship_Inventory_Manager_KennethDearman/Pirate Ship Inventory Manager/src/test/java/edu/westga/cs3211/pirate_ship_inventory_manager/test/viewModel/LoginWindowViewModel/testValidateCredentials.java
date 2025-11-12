package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.LoginWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;

class testValidateCredentials {

	@Test
	public void testInvalidCredentials() {
		LoginWindowViewModel vm = new LoginWindowViewModel();
		vm.getUsername().set("bob");
		vm.getPassword().set("obi");
		
		assertFalse(vm.validateCredentials());
	}
	
	@Test
	public void testInvalidCredentialsCorrectUsernameIncorrectPassword() {
		LoginWindowViewModel vm = new LoginWindowViewModel();
		vm.getUsername().set("PirateBob");
		vm.getPassword().set("obi");
		
		assertFalse(vm.validateCredentials());
	}

	@Test
	public void testValidCredentials() {
		LoginWindowViewModel vm = new LoginWindowViewModel();
		vm.getUsername().set("PirateBob");
		vm.getPassword().set("password123");
		
		assertTrue(vm.validateCredentials());
	}
}
