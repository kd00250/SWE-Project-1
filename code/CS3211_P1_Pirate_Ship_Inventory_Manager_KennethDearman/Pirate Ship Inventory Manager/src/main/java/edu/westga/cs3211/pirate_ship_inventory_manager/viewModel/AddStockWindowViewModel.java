package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import java.util.HashSet;
import java.util.Set;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.SpecialQuality;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
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
public class AddStockWindowViewModel {
	private Inventory inventory;
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
		this.inventory = new Inventory();
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
	 * Adds stock to boxes compartment
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * 
	 * @return true/false depending on if it was added
	 */
	public Boolean addStockToBoxes(Stock stock) {
		return this.inventory.getCompartments().get(0).addStock(stock);
	}
	
	/**
	 * Adds stock to shelves compartment
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * 
	 * @return true/false depending on if it was added
	 */
	public Boolean addStockToShelves(Stock stock) {
		return this.inventory.getCompartments().get(1).addStock(stock);
	}
	
	/**
	 * Adds stock to special storage 1 compartment
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * 
	 * @return true/false depending on if it was added
	 */
	public Boolean addStockToSpecialStorage1(Stock stock) {
		return this.inventory.getCompartments().get(2).addStock(stock);
	}
	
	/**
	 * Adds stock to special storage 2 compartment
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 *@param stock the stock to be added 
	 * 
	 * @return true/false depending on if it was added
	 */
	public Boolean addStockToSpecialStorage2(Stock stock) {
		return this.inventory.getCompartments().get(3).addStock(stock);
	}
	
}
