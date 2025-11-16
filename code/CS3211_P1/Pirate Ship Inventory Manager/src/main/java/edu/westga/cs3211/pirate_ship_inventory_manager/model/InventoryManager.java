package edu.westga.cs3211.pirate_ship_inventory_manager.model;

/**
 * The Inventory manager class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public final class InventoryManager {
	private static InventoryManager instance;
    private Inventory inventory;
    
    private InventoryManager() {
        this.inventory = new Inventory();
    }
    
    /**
     * Gets the instance of the inventory
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the instance of the inventory
     */
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
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
    public Inventory getInventory() {
        return this.inventory;
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
