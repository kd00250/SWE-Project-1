package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.logchange;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;

class testGetDisplayString {

	@Test
	void testGetValidDisplayString() {
		User user = new User("bill", "nye", "Crewmate");
		Compartment box = new Compartment("barrel", 25, true );
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        LogChange change = new LogChange(user, stock, box); 
        
        assertEquals(change.getDisplayString(), "Milk: 5     bill");
	}

}
