package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import java.util.ArrayList;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	private ObjectProperty<Stock> selectedStock;
	private IntegerProperty quantityToTake;
	
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
		this.selectedStock = new SimpleObjectProperty<Stock>();
		this.quantityToTake = new SimpleIntegerProperty();
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
	 * Gets the selectedStockProperty.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the selectedStockProperty
	 */
	public ObjectProperty<Stock> getSelectedStock() {
		return this.selectedStock;
	}

	/**
	 * Gets the quantityToTakeProperty.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the quantityToTakeProperty
	 */
	public IntegerProperty getQuantityToTake() {
		return this.quantityToTake;
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
	
	/**
	 * Gets all Stock in the Inventory of a StockType.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return an ArrayList of Stocks that are a certain StockType
	 */
	public ArrayList<Stock> getStockInInventory() {
		var stockInInventory = new ArrayList<Stock>();
		for (var currCompartment : this.inventory.getCompartments()) {
			var stocksInCompartment = currCompartment.getStockOfType(this.stockTypeProperty.get());
			stockInInventory.addAll(stocksInCompartment);
		}
		return stockInInventory;
	}
	
	public boolean takeStockFromInventory() {
		var result = false;
		
		var stockToTake = this.selectedStock.get();
		var quantityToTake = this.quantityToTake.get();
		Compartment compartmentToTakeFrom = null;
		
		for (var currCompartment : this.inventory.getCompartments()) {
			if (currCompartment.getStorage().contains(stockToTake)) {
				compartmentToTakeFrom = currCompartment;
				break;
			}
		}
		if (compartmentToTakeFrom != null && compartmentToTakeFrom.removeStock(stockToTake, quantityToTake)) {
			result = true;
		}
		return result;
	}
	
	public boolean isQuantityToTakeValid() {
		if (this.selectedStock.get() == null) {
			return false;
		}
		return this.quantityToTake.get() <= this.selectedStock.get().getQuantity();
	}
}
