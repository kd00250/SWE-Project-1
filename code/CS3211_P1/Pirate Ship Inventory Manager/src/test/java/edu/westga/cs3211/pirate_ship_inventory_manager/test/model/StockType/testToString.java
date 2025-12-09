package edu.westga.cs3211.pirate_ship_inventory_manager.test.model.StockType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;

public class testToString {
	
	@ParameterizedTest
	@CsvSource({"DEFAULT,Default","FOOD,Food","MUNITION,Munition"})
	void testNameMatchesToString(String enumName, String expected) {
		var stockType = StockType.valueOf(enumName);
		assertEquals(expected, stockType.toString());
	}
}
