package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Compartment;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The viewmodel the addStokcWindow of the application
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class AddStockWindowViewModel extends SessionViewModel {
	private Inventory inventory; 
	private LogChangesInventory logInventory;
	private StringProperty name;
	private StringProperty quantity;
	private StringProperty condition;
	private StringProperty expirationDate;
	private BooleanProperty isFlammable;
	private BooleanProperty isPerishable;
	private BooleanProperty isLiquid;
	
	/**
	 * Creates a new instance of AddStockViewModel
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public AddStockWindowViewModel() {
		this.inventory = InventoryManager.getInstance().getInventory();
		this.logInventory = LogManager.getInstance().getLogChangesInventory();
		this.name = new SimpleStringProperty();
		this.quantity = new SimpleStringProperty();
		this.condition = new SimpleStringProperty();
		this.isFlammable = new SimpleBooleanProperty();
		this.isPerishable = new SimpleBooleanProperty();
		this.isLiquid = new SimpleBooleanProperty(); 
		this.expirationDate = new SimpleStringProperty();
	}
	
	/**
	 * gets the isflammable property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the isflammable property
	 */
	public BooleanProperty getIsFlammableProperty() {
        return this.isFlammable;
    }
	
	/**
	 * gets the isPerishable property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the isPerishable property
	 */
	public BooleanProperty getIsPerishableProperty() {
        return this.isPerishable;
    }
	
	/**
	 * gets the isLiquid property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the isLiquid property
	 */
	public BooleanProperty getIsLiquidProperty() {
        return this.isLiquid;
    }
	
	/**
	 * gets the name 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name
	 */
	public StringProperty getName() {
		return this.name;
	}
	
	/**
	 * gets the condition 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the condition
	 */
	public StringProperty getCondition() {
		return this.condition;
	}
	
	/**
	 * gets the quantity 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the quantity
	 */
	public StringProperty getQuantity() {
		return this.quantity;
	}
	
	/**
	 * gets the expiration date
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the expiration date
	 */
	public StringProperty getExpirationDate() {
		return this.expirationDate;
	}
	
	/**
	 * Creates stock from the user input
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the stock made from the user input
	 */ 
	public Stock createStock() {
		String name = this.getName().get();
		String condition = this.getCondition().get();
		String expirationDate = this.getExpirationDate().get();
		Integer quantity = Integer.parseInt(this.getQuantity().get());
		Set<SpecialQuality> specialQualities = new HashSet<SpecialQuality>();
		if (this.getIsFlammableProperty().get()) {
			specialQualities.add(SpecialQuality.FLAMMABLE);
		}
		if (this.getIsLiquidProperty().get()) {
			specialQualities.add(SpecialQuality.LIQUID);
		}
		if (this.getIsPerishableProperty().get()) {
			specialQualities.add(SpecialQuality.PERISHABLE);
		}
		
		Stock stock = new Stock(quantity, specialQualities, name, condition, expirationDate);
		return stock;
	}
	 
	/**
	 * Adds stock to specified compartment
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param user the user to be added
	 * @param compartmentName the name of the compartment 
	 * @param stock the stock to be added
	 * 
	 * @return true/false if the stock can be added or not
	 */
	public Boolean addStockToCompartment(User user, String compartmentName, Stock stock) {
		for (Compartment currentCompartment : this.inventory.getCompartments()) {
			if (currentCompartment.getName().equals(compartmentName)) {
				if (currentCompartment.addStock(stock)) {
					LogChange change = new LogChange(user, stock, currentCompartment);
					this.logInventory.addLogChange(change);
					return true;
				}
			}
		}
		return false;
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
	
	/**
	 * Gets the normal storage names
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * @return a list of normal storage compartment names
	 */
	public ArrayList<String> getNormalStorage(Stock stock) {
		return this.inventory.getNormalStorage(this.inventory.getCompartments(), stock);
	}
	
	/**
	 * Gets the special storage names
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * @return a list of special storage compartment names
	 */
	public ArrayList<String> getSpecialStorageForStock(Stock stock) {
		return this.inventory.getSpecialStorage(this.inventory.getCompartments(), stock);
	}
	
	/**
	 * Checks if the normal storage has any free space for the stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * @return true/false if there is space for the stock
	 */
	public boolean normalStorageHasFreeSpace(Stock stock) {
		for (Compartment currentCompartment : this.inventory.getCompartments()) {
			if (!currentCompartment.getIsSpecialQualitiesStorage()) {
				if (currentCompartment.getRemainingCapacity() >= stock.getQuantity()) {
					return true;
				}
			} 
		}
		return false;
	}
	
	/**
	 * Checks if the special storage has any free space for the stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * @return true/false if there is space for the stock
	 */
	public boolean specialStorageHasFreeSpace(Stock stock) {
		for (Compartment currentCompartment : this.inventory.getCompartments()) {
	        if ((currentCompartment.getName().equals("Flammable Storage") && stock.isFlammable()) 
	        		|| (currentCompartment.getName().equals("Liquid Storage") && stock.isLiquid()) 
	        		|| (currentCompartment.getName().equals("Perishable Storage") && stock.isPerishable())) {
	            
	            if (currentCompartment.getRemainingCapacity() >= stock.getQuantity()) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
}
