package edu.westga.cs1302.javafx_sample.test.viewModel.LoginWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_sample.viewModel.LoginWindowViewModel;

class testValidateCredentials {

	@Test
	public void testInvalidCredentials() {
		LoginWindowViewModel vm = new LoginWindowViewModel();
		vm.getUsername().set("bob");
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
