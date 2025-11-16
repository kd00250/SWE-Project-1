package edu.westga.cs3211.pirate_ship_inventory_manager.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The Log Changes Class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class LogChangesInventory {
	private ArrayList<LogChange> changes;
	private Inventory inventory;
	
	/**
	 * Creates a new instance of logChangesInventory
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public LogChangesInventory() {
		this.changes = new ArrayList<LogChange>();
		this.inventory = InventoryManager.getInstance().getInventory();
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.LIQUID);
        Stock stock1 = new Stock(1, new HashSet<>(), "Paper", "perfect", null);
        Stock stock2 = new Stock(1, qualities, "Oil", "perfect", null);
        UserStore store = new UserStore();
        LogChange change1 = new LogChange(store.getUserList().get(0), stock1, this.inventory.getCompartments().get(0));
        LogChange change2 = new LogChange(store.getUserList().get(0), stock2, this.inventory.getCompartments().get(3));
        
        this.changes.add(change1);
        this.changes.add(change2);
	}
	
	/**
	 * Gets a list of log changes
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a list of the log changes
	 */
	public ArrayList<LogChange> getLogChanges() {
		return this.changes;
	}
	
	/**
	 * adds change to the change logs
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param change the change to be added
	 * @return true/false depending on if the change is added or not
	 */
	public boolean addLogChange(LogChange change) {
		if (change == null) {
			throw new IllegalArgumentException("Change cannot be null");
		}
		this.changes.add(change);
		return true;
	}
}
