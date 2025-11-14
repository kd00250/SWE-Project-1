package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.logchangesinventory;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.UserStore;

class testAddLogChange {

	@Test
	void testAddLogChangeTrue() {
		User user = new User("bill", "nye", "CrewMate");
		Compartment box = new Compartment("barrel", 25, true );
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        LogChange change = new LogChange(user, stock, box); 
        LogChangesInventory lci = new LogChangesInventory();
        
        assertTrue(lci.addLogChange(change));
        assertThrows(IllegalArgumentException.class, () -> {
        	new LogChange(null, stock, box);
		});
	}
	
	@Test
	void testAddLogChangeNull() {
        LogChangesInventory lci = new LogChangesInventory();
        
        assertThrows(IllegalArgumentException.class, () -> {
        	lci.addLogChange(null);
		});
	}
	
	

}
