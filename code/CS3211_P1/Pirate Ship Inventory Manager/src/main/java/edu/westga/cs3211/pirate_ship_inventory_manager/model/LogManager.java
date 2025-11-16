package edu.westga.cs3211.pirate_ship_inventory_manager.model;

/**
 * The Log Manager Class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public final class LogManager {
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
    
    /**
     * Resets the singleton instance (used for testing purpose only)
     * 
     * @precondition none
     * @postcondition instance is set to null, next getInstance() call creates fresh instance
     */
    public static void resetInstance() {
        instance = null;
    }
}
