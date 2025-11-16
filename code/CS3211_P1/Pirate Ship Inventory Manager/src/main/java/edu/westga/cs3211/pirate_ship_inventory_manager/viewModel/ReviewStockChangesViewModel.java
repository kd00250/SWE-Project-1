package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChange;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.User;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.UserStore;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The viewmodel the reviewStockWindow of the application
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class ReviewStockChangesViewModel {
	private LogChangesInventory logInventory;
	private UserStore store;
	private StringProperty filter;
	private BooleanProperty isLiquid;
	private BooleanProperty isFlammable;
	private BooleanProperty isPerishable;
	private StringProperty startDate;
	private StringProperty endDate;
	
	/**
	 * Creates a new instance of reviewStockChangesViewModel
	 */
	public ReviewStockChangesViewModel() {
		this.logInventory = LogManager.getInstance().getLogChangesInventory();
		this.store = new UserStore();
		this.filter = new SimpleStringProperty();
		this.isLiquid = new SimpleBooleanProperty();
		this.isFlammable = new SimpleBooleanProperty();
		this.isPerishable = new SimpleBooleanProperty();
		this.startDate = new SimpleStringProperty();
		this.endDate = new SimpleStringProperty();
	}
	
	/**
	 * gets the filter property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the filter property
	 */
	public StringProperty getFilter() {
		return this.filter;
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
	 * gets the startDate property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the startDate property
	 */
	public StringProperty getStartDate() {
		return this.startDate;
	}
	
	/**
	 * gets the endDate property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the endDate property
	 */
	public StringProperty getEndDate() {
		return this.endDate;
	}
	
	/**
	 * gets a list of crew names
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a list of crew names
	 */
	public ArrayList<String> getCrewList() {
		ArrayList<String> names = new ArrayList<String>();
		for (User currentUser : this.store.getUserList()) {
			names.add(currentUser.getUsername());
		}
		return names;
	}
	
	/**
	 * Gets the filtered list of special quantity items
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param isFlammable the flammable property
	 * @param isLiquid the liquid property
	 * @param isPerishable the perishable property
	 * @return the arraylist of special quantity log changes
	 */
	public ArrayList<String> getSpecialQuantityFilter(Boolean isFlammable, Boolean isLiquid, Boolean isPerishable) {
		ArrayList<String> result = new ArrayList<String>();
	    
	    for (LogChange currentChange : this.logInventory.getLogChanges()) {
	        Stock stock = currentChange.getStock();
	        
	        if (stock.getHasSpecialQualities()) {
	            boolean matchesFilter = false;
	            
	            if (isFlammable && stock.isFlammable()) {
	                matchesFilter = true;
	            }
	            if (isLiquid && stock.isLiquid()) {
	                matchesFilter = true;
	            }
	            if (isPerishable && stock.isPerishable()) {
	                matchesFilter = true;
	            }
	            
	            if (matchesFilter) {
	                result.add(currentChange.getDisplayString());
	            }
	        }
	    }
	    
	    return result;
	}
	
	/**
	 * Gets the list of log changes for the start date
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param startDate the startDate 
	 * @return a list of log changes based on the start date
	 */
	public ArrayList<String> getStartDateFilter(String startDate) {
		ArrayList<String> result = new ArrayList<String>();
	    
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        dateFormat.setLenient(false);
	        Date parsedStartDate = dateFormat.parse(startDate);
	        
	        for (LogChange currentChange : this.logInventory.getLogChanges()) {
	            Stock stock = currentChange.getStock();
	            
	            if (stock.getExpirationDate() != null) {
	                Date expirationDate = dateFormat.parse(stock.getExpirationDate());
	                
	                if (expirationDate.after(parsedStartDate)) {
	                    result.add(currentChange.getDisplayString());
	                }
	            }
	        }
	    } catch (ParseException e) {
	    	throw new IllegalArgumentException("Invalid Date format: " + startDate);
	    }
	    
	    return result;
	}
	
	/**
	 * Gets the start and end date filtered log changes
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param startDate the startDate 
	 * @param endDate the endDate 
	 * @return a list of filtered log changes
	 */
	public ArrayList<String> getStartAndEndDateFilter(String startDate, String endDate) {
	    ArrayList<String> result = new ArrayList<String>();

	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        dateFormat.setLenient(false);
	        Date parsedStartDate = dateFormat.parse(startDate);
	        Date parsedEndDate = dateFormat.parse(endDate);

	        for (LogChange currentChange : this.logInventory.getLogChanges()) {
	            Stock stock = currentChange.getStock();

	            if (stock.getExpirationDate() != null) {
	                Date expirationDate = dateFormat.parse(stock.getExpirationDate());

	                if (expirationDate.after(parsedStartDate) && 
	                    (expirationDate.before(parsedEndDate) || expirationDate.equals(parsedEndDate))) {
	                    result.add(currentChange.getDisplayString());
	                }
	            }
	        }
	    } catch (ParseException e) {
	    	throw new IllegalArgumentException("Invalid Date format: " + startDate + " or " + endDate);
	    }

	    return result;
	}
	
	/**
	 * Returns the filtered list of log changes
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param names the names of the crewmates selected
	 * @return the log changes that match the names of the crewmates
	 */
	public ArrayList<String> getCrewmateFilter(ArrayList<String> names) {
		ArrayList<String> result = new ArrayList<String>();
		for (String currentName : names) {
			for (LogChange currentChange : this.logInventory.getLogChanges()) {
				if (currentChange.getUser().getUsername().equals(currentName)) {
					result.add(currentChange.getDisplayString());
				}
			}
		}
		return result;
	}
	//TODO TEST!!!!!
	
	/**
	 * Gets the log changes
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of log changes
	 */
	public ArrayList<String> getLogChanges() {
		ArrayList<String> result = new ArrayList<String>();
		for (LogChange currentChange : this.logInventory.getLogChanges()) {
			result.add(currentChange.getDisplayString());
		}
		Collections.reverse(result);
		return result;
	}
	
	
//	/**
//     * Filters log changes by selected crewmates
//     *
//     * @precondition none
//	 * @postcondition none
//     *
//     * @param selectedCrewmates the list of selected crewmate names
//     */
//    public ArrayList<String> filterByCrewmates(ArrayList<String> selectedCrewmates) {
//    	ArrayList<String> result = new ArrayList<String>();
//        for (String current : selectedCrewmates) {
//        	for (LogChange currentLog : this.logInventory.getLogChanges()) {
//        		if (currentLog.getUser().getUsername().equals(current)) {
//        			result.add(currentLog.getDisplayString());
//        		}
//        	}
//        }
//        return result;
//    }
}
