package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import java.util.ArrayList;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * The InventoryPageWindowViewModel class.
 * 
 * @version Fall 2025
 * @author CS3211
 */
public class InventoryPageWindowViewModel extends SessionViewModel {
	
	private Inventory inventory;
	private LogChangesInventory logInventory;
	private ObjectProperty<StockType> stockTypeProperty;
	
	/**
	 * The viewmodel the InventoryPageWindowViewModel
	 * 
	 * @author CS3211
	 * @version Fall 2025
	 */
	public InventoryPageWindowViewModel() {
		this.inventory = InventoryManager.getInstance().getInventory();
		this.logInventory = LogManager.getInstance().getLogChangesInventory();
		this.stockTypeProperty = new SimpleObjectProperty<StockType>();
	}
	
	/**
	 * Gets the stockTypeProperty.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the stockTypeProperty
	 */
	public ObjectProperty<StockType> getStockTypeProperty() {
		return this.stockTypeProperty;
	}

	/**
	 * Checks each Container in Inventory and sees if it contains a Stock of StockType.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if any container contains the StockType Selected, false otherwise.
	 */
	public boolean isStockTypeInInventory() {
		var specificStockType = this.stockTypeProperty.get();
		for (var currCompartment : this.inventory.getCompartments()) {
			if (currCompartment.doesContainStockOfType(specificStockType)) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<Stock> getStockInInventory() {
		var stockInInventory = new ArrayList<Stock>();
		for (var currCompartment : this.inventory.getCompartments()) {
			var stocksInCompartment = currCompartment.getStockOfType(this.stockTypeProperty.get());
			stockInInventory.addAll(stocksInCompartment);
		}
		return stockInInventory;
	}
}
