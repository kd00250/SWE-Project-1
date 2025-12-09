package edu.westga.cs3211.pirate_ship_inventory_manager.test.viewModel.AddStockWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;

class testAddStockToCompartment {

	@BeforeEach
    void setUp() {
        InventoryManager.resetInstance();
    }
	
	@Test
	void testAddStockToBoxesTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("1"); 
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		assertTrue(vm.addStockToCompartment(user, "Boxes", vm.createStock()));
	}
	
	@Test
	void testAddStockToBoxesFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertFalse(vm.addStockToCompartment(user, "Boxes", vm.createStock()));
	}
	
	@Test
	void testAddStockToShelvesTrue() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Shelves", vm.createStock()));
	}
	
	@Test
	void testAddStockToShelvesFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertFalse(vm.addStockToCompartment(user, "Shelves",vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage1True() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Flammable Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage1False() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		//vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertFalse(vm.addStockToCompartment(user, "Flammmable Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage2True() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Liquid Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage2True2Qualities() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Liquid Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage2TrueAllQualities() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(true);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Liquid Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage2False() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertFalse(vm.addStockToCompartment(user, "Liquid Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage3True() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Perishable Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage3True2Qualities() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(false);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Perishable Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage3TrueAllQualities() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(true);
		vm.getIsLiquidProperty().set(true);
		vm.getIsPerishableProperty().set(true);
		vm.getExpirationDate().set("12/12/2004");
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertTrue(vm.addStockToCompartment(user, "Perishable Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockToSpecialStorage3False() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		assertFalse(vm.addStockToCompartment(user, "Perishable Storage", vm.createStock()));
	}
	
	@Test
	void testAddStockCompartmentNotValidFalse() {
		AddStockWindowViewModel vm = new AddStockWindowViewModel();
		User user = new User("bill", "nye", "Crewmate");
		vm.getCondition().set("perfect");
		vm.getName().set("apple");
		vm.getIsFlammableProperty().set(false);
		vm.getIsLiquidProperty().set(false);
		vm.getIsPerishableProperty().set(false);
		vm.getQuantity().set("3");
		vm.getStockTypeProperty().set(StockType.DEFAULT);
		
		assertFalse(vm.addStockToCompartment(user, "Pockets", vm.createStock()));
	}

}
