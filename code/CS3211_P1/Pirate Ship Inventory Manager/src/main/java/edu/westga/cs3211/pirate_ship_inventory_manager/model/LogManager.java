package edu.westga.cs3211.pirate_ship_inventory_manager.model;

public class LogManager {
	private static LogManager instance;
    private LogChangesInventory logInventory;
    
    private LogManager() {
        this.logInventory = new LogChangesInventory();
    }
    
    /**
     * Gets the instance of the inventory
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the instance of the inventory
     */
    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }
    
    /**
     * Gets the inventory
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the inventory
     */
    public LogChangesInventory getLogChangesInventory() {
        return this.logInventory;
    }
}
