package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import java.util.ArrayList;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.ChangeAction;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
	private BooleanProperty shouldDisableTakeStock;
	
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
		this.shouldDisableTakeStock = new SimpleBooleanProperty(true);
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
	 * Gets the shouldDisableTakeStockProperty.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the shouldDisableTakeStockProperty
	 */
	public BooleanProperty getShouldDisableTakeStock() {
		return this.shouldDisableTakeStock;
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
	
	/**
	 * Takes the selected Stock from the Inventory
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param user the User
	 * 
	 * @return true if the Stock was removed, false otherwise.
	 */
	public boolean takeStockFromInventory(User user) {
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
		if (compartmentToTakeFrom != null) {
			if (compartmentToTakeFrom.removeStock(stockToTake, quantityToTake)) {
				var logChange = new LogChange(user, stockToTake, compartmentToTakeFrom, ChangeAction.REMOVED);
				this.logInventory.addLogChange(logChange);
				this.selectedStock.set(null);
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Checks if the quantityToTake is <= the selectedStock quantity
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public void isQuantityToTakeValid() {
		if (this.selectedStock.get() == null) {
			this.shouldDisableTakeStock.set(true);
		} else if (this.quantityToTake.get() == 0) {
			this.shouldDisableTakeStock.set(true);
		} else if (this.quantityToTake.get() <= this.selectedStock.get().getQuantity()) {
			this.shouldDisableTakeStock.set(false);
		} else {
			this.shouldDisableTakeStock.set(true);
		}
	}
	
	/**
	 * Gets the summary message
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the summary string
	 */
	public String getSummaryMessage() {
		LogChange change = this.logInventory.getLogChanges().getLast();
		return change.toString();
	}
}
