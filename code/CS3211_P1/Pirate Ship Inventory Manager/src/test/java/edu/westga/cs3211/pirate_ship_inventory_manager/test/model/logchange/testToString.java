package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.logchange;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;

class testToString {

	@Test
	void testValidToString() {
		User user = new User("bill", "nye", "Crewmate");
		Compartment box = new Compartment("barrel", 25, false);
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        box.addStock(stock);
        LogChange change = new LogChange(user, stock, box); 
        String expectedDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        assertEquals(change.toString(), "User: bill (Crewmate)\nStock Info: \nName: Milk\nQuantity: 5\nCondition: perfect\nFlammable: false\n"
        		+ "Liquid: false\nPerishable: false\nExpiration Date: 12/12/2025\nStorage Compartment: barrel\n"
        				+ "Remaining Capacity: 20\nDate Added: " + expectedDate);
	}

}
