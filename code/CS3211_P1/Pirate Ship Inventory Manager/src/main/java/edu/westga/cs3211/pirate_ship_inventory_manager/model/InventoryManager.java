package edu.westga.cs3211.pirate_ship_inventory_manager.model;

public class InventoryManager {
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
}
