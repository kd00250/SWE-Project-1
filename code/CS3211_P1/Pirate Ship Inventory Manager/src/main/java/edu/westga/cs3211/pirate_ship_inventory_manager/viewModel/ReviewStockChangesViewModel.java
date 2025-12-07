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
public class ReviewStockChangesViewModel extends SessionViewModel {
	private LogChangesInventory logInventory;
	private UserStore store;
	private StringProperty filter;
	private BooleanProperty isLiquid;
	private BooleanProperty isFlammable;
	private BooleanProperty isPerishable;
	private StringProperty startDate;
	private StringProperty endDate;
	private StringProperty hoursStartDate;
	private StringProperty minutesStartDate;
	private StringProperty secondsStartDate;
	private StringProperty hoursEndDate;
	private StringProperty minutesEndDate;
	private StringProperty secondsEndDate;
	
	/**
	 * Creates a new instance of reviewStockChangesViewModel
	 */
	public ReviewStockChangesViewModel() {
		super();
		this.logInventory = LogManager.getInstance().getLogChangesInventory();
		this.store = new UserStore();
		this.filter = new SimpleStringProperty();
		this.isLiquid = new SimpleBooleanProperty();
		this.isFlammable = new SimpleBooleanProperty();
		this.isPerishable = new SimpleBooleanProperty();
		this.startDate = new SimpleStringProperty();
		this.endDate = new SimpleStringProperty();
		this.hoursStartDate = new SimpleStringProperty();
		this.minutesStartDate = new SimpleStringProperty();
		this.secondsStartDate = new SimpleStringProperty();
		this.hoursEndDate = new SimpleStringProperty();
		this.minutesEndDate = new SimpleStringProperty();
		this.secondsEndDate = new SimpleStringProperty();
	}
	
	/**
	 * gets the hours end date property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the hours end date property
	 */
	public StringProperty getHoursStartDate() {
		return this.hoursStartDate;
	}
	
	/**
	 * gets the minutes start date property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the minutes start date property
	 */
	public StringProperty getMinutesStartDate() {
		return this.minutesStartDate;
	}
	
	/**
	 * gets the seconds start date property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the seconds start date property
	 */
	public StringProperty getSecondsStartDate() {
		return this.secondsStartDate;
	}
	
	/**
	 * gets the hours end date property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the hours end date property
	 */
	public StringProperty getHoursEndDate() {
		return this.hoursEndDate;
	}
	
	/**
	 * gets the minutes end date property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the minutes end date property
	 */
	public StringProperty getMinutesEndDate() {
		return this.minutesEndDate;
	}
	
	/**
	 * gets the seconds end date property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the seconds end date property
	 */
	public StringProperty getSecondsEndDate() {
		return this.secondsEndDate;
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
	        	Date date = dateFormat.parse(currentChange.getDate());
	            if (date.after(parsedStartDate) || date.equals(parsedStartDate)) {
	            	result.add(currentChange.getDisplayString());
	            }
	        }
	    } catch (ParseException ex) {
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
	        	Date date = dateFormat.parse(currentChange.getDate());
	        	if ((date.after(parsedStartDate) || date.equals(parsedStartDate))  && (date.before(parsedEndDate) || date.equals(parsedEndDate))) {
	        		result.add(currentChange.getDisplayString());
	        	}
	        }
	    } catch (ParseException ex) {
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
	
	/**
	 * Gets the logchanges that are after or equal to the start date
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param startDate the start date
	 * @return a list of log changes
	 */
	public ArrayList<LogChange> getStartDateFilterForTime(String startDate) {
		ArrayList<LogChange> result = new ArrayList<LogChange>();
	    
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        dateFormat.setLenient(false);
	        Date parsedStartDate = dateFormat.parse(startDate);
	        
	        for (LogChange currentChange : this.logInventory.getLogChanges()) {
	        	Date date = dateFormat.parse(currentChange.getDate());
	            if (date.after(parsedStartDate) || date.equals(parsedStartDate)) {
	            	result.add(currentChange);
	            }
	        }
	    } catch (ParseException ex) {
	    	throw new IllegalArgumentException("Invalid Date format: " + startDate);
	    }
	    
	    return result;
	}
	
	/**
	 * Gets logchanges for date ranges
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return arraylist of log changes
	 */
	public ArrayList<LogChange> getStartAndEndDateFilterForTime(String startDate, String endDate) {
	    ArrayList<LogChange> result = new ArrayList<LogChange>();

	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        dateFormat.setLenient(false);
	        Date parsedStartDate = dateFormat.parse(startDate);
	        Date parsedEndDate = dateFormat.parse(endDate);

	        for (LogChange currentChange : this.logInventory.getLogChanges()) {
	        	Date date = dateFormat.parse(currentChange.getDate());
	        	if ((date.after(parsedStartDate) || date.equals(parsedStartDate))  && (date.before(parsedEndDate) || date.equals(parsedEndDate))) {
	        		result.add(currentChange);
	        	}
	        }
	    } catch (ParseException ex) {
	    	throw new IllegalArgumentException("Invalid Date format: " + startDate + " or " + endDate);
	    }

	    return result;
	}
	
	/**
	 * filters the changes by the time specified
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param changes the changes from the date
	 * @param hours the hours entered
	 * @param minutes the minutes entered
	 * @param seconds the seconds entered
	 * @return arraylist of changes
	 */
	public ArrayList<String> getStartTimeChanges(ArrayList<LogChange> changes, String hours, String minutes, String seconds) {
		ArrayList<String> result = new ArrayList<String>();
		try {
	        int startHours;
	        if (hours.isEmpty()) {
	            startHours = 0;
	        } else {
	            startHours = Integer.parseInt(hours);
	        }
	        int startMinutes;
	        if (minutes.isEmpty()) {
	            startMinutes = 0;
	        } else {
	            startMinutes = Integer.parseInt(minutes);
	        }
	        int startSeconds;
	        if (seconds.isEmpty()) {
	            startSeconds = 0;
	        } else {
	            startSeconds = Integer.parseInt(seconds);
	        }
	        int startTimeInSeconds = (startHours * 3600) + (startMinutes * 60) + startSeconds;
	        for (LogChange currentChange : changes) {
	            String timeString = currentChange.getTime(); 

	            int changeHours = Integer.parseInt(timeString.substring(0, 2));
	            int changeMinutes = Integer.parseInt(timeString.substring(3, 5));
	            int changeSeconds = Integer.parseInt(timeString.substring(6, 8));
	            
	            int changeTimeInSeconds = (changeHours * 3600) + (changeMinutes * 60) + changeSeconds;
	            
	            if (changeTimeInSeconds >= startTimeInSeconds) {
	                result.add(currentChange.getDisplayString());
	            }
	        }
	    } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
	        throw new IllegalArgumentException("Invalid time format");
	    }
	    return result;
	}
	
	/**
	 * filters the changes by the time specified
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param changes the changes from the date
	 * @param hours the hours entered
	 * @param minutes the minutes entered
	 * @param seconds the seconds entered
	 * @return arraylist of changes
	 */
	public ArrayList<String> getStartTimeChangesForEndTime(ArrayList<LogChange> changes, String hours, String minutes, String seconds) {
		ArrayList<String> result = new ArrayList<String>();
		try {
	        int endHours;
	        if (hours.isEmpty()) {
	            endHours = 0;
	        } else {
	            endHours = Integer.parseInt(hours);
	        }
	        int endMinutes;
	        if (minutes.isEmpty()) {
	            endMinutes = 0;
	        } else {
	            endMinutes = Integer.parseInt(minutes);
	        }
	        int endSeconds;
	        if (seconds.isEmpty()) {
	            endSeconds = 0;
	        } else {
	            endSeconds = Integer.parseInt(seconds);
	        }
	        int endTimeInSeconds = (endHours * 3600) + (endMinutes * 60) + endSeconds;
	        for (LogChange currentChange : changes) {
	            String timeString = currentChange.getTime(); 

	            int changeHours = Integer.parseInt(timeString.substring(0, 2));
	            int changeMinutes = Integer.parseInt(timeString.substring(3, 5));
	            int changeSeconds = Integer.parseInt(timeString.substring(6, 8));
	            
	            int changeTimeInSeconds = (changeHours * 3600) + (changeMinutes * 60) + changeSeconds;
	            
	            if (changeTimeInSeconds <= endTimeInSeconds) {
	                result.add(currentChange.getDisplayString());
	            }
	        }
	    } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
	        throw new IllegalArgumentException("Invalid time format");
	    }
	    return result;
	}
	
	private int parseTimeComponent(String value, int defaultValue) {
	    if (value.isEmpty()) {
	        return defaultValue;
	    }
	    return Integer.parseInt(value);
	}

	private int convertToSeconds(int hours, int minutes, int seconds) {
	    return (hours * 3600) + (minutes * 60) + seconds;
	}
	
	/**
	 * gets the list of changes at the start date and between the entered time range
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param changes the changes to be returned
	 * @param startTimeValues the start time
	 * @param endTimeValues the end time
	 * @return the list of changes after the start date and between the time range
	 */
	public ArrayList<String> getStartAndEndTimeChanges(ArrayList<LogChange> changes, String startTimeValues, String endTimeValues) {
		ArrayList<String> result = new ArrayList<String>();
	    try {
	    	String[] startParts = startTimeValues.split(",", -1);
	        String startHours = startParts[0];
	        String startMinutes = startParts[1];
	        String startSeconds = startParts[2];
	        
	        String[] endParts = endTimeValues.split(",", -1);
	        String endHours = endParts[0];
	        String endMinutes = endParts[1];
	        String endSeconds = endParts[2];
	        int startHoursInt = this.parseTimeComponent(startHours, 0);
	        int startMinutesInt = this.parseTimeComponent(startMinutes, 0);
	        int startSecondsInt = this.parseTimeComponent(startSeconds, 0);
	        int startTimeInSeconds = this.convertToSeconds(startHoursInt, startMinutesInt, startSecondsInt);

	        int endHoursInt = this.parseTimeComponent(endHours, 23);
	        int endMinutesInt = this.parseTimeComponent(endMinutes, 59);
	        int endSecondsInt = this.parseTimeComponent(endSeconds, 59);
	        int endTimeInSeconds = this.convertToSeconds(endHoursInt, endMinutesInt, endSecondsInt);
	       
	        for (LogChange currentChange : changes) {
	            String timeString = currentChange.getTime();
	            
	            int changeHours = Integer.parseInt(timeString.substring(0, 2));
	            int changeMinutes = Integer.parseInt(timeString.substring(3, 5));
	            int changeSeconds = Integer.parseInt(timeString.substring(6, 8));
	            
	            int changeTimeInSeconds = this.convertToSeconds(changeHours, changeMinutes, changeSeconds);
	            
	            if (changeTimeInSeconds >= startTimeInSeconds && changeTimeInSeconds <= endTimeInSeconds) {
	                result.add(currentChange.getDisplayString());
	            }
	        }
	    } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
	        throw new IllegalArgumentException("Invalid time format");
	    }
	    return result;
	}
}
