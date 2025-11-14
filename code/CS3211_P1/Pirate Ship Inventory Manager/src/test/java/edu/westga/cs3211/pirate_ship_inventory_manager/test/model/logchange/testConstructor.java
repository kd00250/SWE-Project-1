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

class testConstructor {

	@Test
	void testValidConstructor() {
		User user = new User("bill", "nye", "Crewmate");
		Compartment box = new Compartment("barrel", 25, true );
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        LogChange change = new LogChange(user, stock, box); 
        String expectedDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        assertEquals(change.getUser(), user);
        assertEquals(change.getCompartment(), box);
        assertEquals(change.getStock(), stock);
        assertEquals(change.getTime(), expectedDate);

	}
	
	@Test
	void testInvalidConstructorStockNull() {
		Compartment box = new Compartment("barrel", 25, true );
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        
        assertThrows(IllegalArgumentException.class, () -> {
        	new LogChange(null, stock, box);
		});

	}
	
	@Test
	void testInvalidConstructorUserNull() {
		User user = new User("bill", "nye", "CrewMate");
		Compartment box = new Compartment("barrel", 25, true );
        
        assertThrows(IllegalArgumentException.class, () -> {
        	new LogChange(user, null, box);
		});

	}
	
	@Test
	void testInvalidConstructorCompartmentNull() {
		User user = new User("bill", "nye", "CrewMate");
		Set<SpecialQuality> qualities = new HashSet<>();
        Stock stock = new Stock(5, qualities, "Milk", "perfect", "12/12/2025");
        
        assertThrows(IllegalArgumentException.class, () -> {
        	new LogChange(user, stock, null);
		});

	}
	
	

}
