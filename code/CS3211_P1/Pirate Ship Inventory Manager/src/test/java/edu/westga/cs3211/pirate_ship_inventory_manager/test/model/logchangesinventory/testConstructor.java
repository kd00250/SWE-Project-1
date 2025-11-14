package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.logchangesinventory;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.UserStore;

class testConstructor {

	@Test
	void testvalidConstructor() {
		LogChangesInventory lci = new LogChangesInventory();
		Inventory inventory = InventoryManager.getInstance().getInventory();
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.LIQUID);
        Stock stock1 = new Stock(1, new HashSet<>(), "Paper","perfect", null);
        Stock stock2 = new Stock(1, qualities, "Oil","perfect", null);
        UserStore store = new UserStore();
        String expectedDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
		assertEquals(lci.getLogChanges().get(0).getUser().getUsername(), store.getUserList().get(0).getUsername());
		assertEquals(lci.getLogChanges().get(0).getUser().getPassword(), store.getUserList().get(0).getPassword());
		assertEquals(lci.getLogChanges().get(0).getUser().getRole(), store.getUserList().get(0).getRole());
		assertEquals(lci.getLogChanges().get(0).getStock().getQuantity(), stock1.getQuantity());
		assertEquals(lci.getLogChanges().get(0).getStock().getName(), stock1.getName());
		assertEquals(lci.getLogChanges().get(0).getStock().getCondition(), stock1.getCondition());
		assertEquals(lci.getLogChanges().get(0).getStock().getExpirationDate(), stock1.getExpirationDate());
		assertFalse(lci.getLogChanges().get(0).getStock().getHasSpecialQualities());
		assertEquals(lci.getLogChanges().get(0).getCompartment().getName(), inventory.getCompartments().get(0).getName());
		assertEquals(lci.getLogChanges().get(0).getTime(), expectedDate);
		
		assertEquals(lci.getLogChanges().get(1).getUser().getUsername(), store.getUserList().get(0).getUsername());
		assertEquals(lci.getLogChanges().get(1).getUser().getPassword(), store.getUserList().get(0).getPassword());
		assertEquals(lci.getLogChanges().get(1).getUser().getRole(), store.getUserList().get(0).getRole());
		assertEquals(lci.getLogChanges().get(1).getStock().getQuantity(), stock2.getQuantity());
		assertEquals(lci.getLogChanges().get(1).getStock().getName(), stock2.getName());
		assertEquals(lci.getLogChanges().get(1).getStock().getCondition(), stock2.getCondition());
		assertEquals(lci.getLogChanges().get(1).getStock().getExpirationDate(), stock2.getExpirationDate());
		assertTrue(lci.getLogChanges().get(1).getStock().getHasSpecialQualities());
		assertEquals(lci.getLogChanges().get(1).getCompartment().getName(), inventory.getCompartments().get(3).getName());
		assertEquals(lci.getLogChanges().get(1).getTime(), expectedDate);
	}

}
