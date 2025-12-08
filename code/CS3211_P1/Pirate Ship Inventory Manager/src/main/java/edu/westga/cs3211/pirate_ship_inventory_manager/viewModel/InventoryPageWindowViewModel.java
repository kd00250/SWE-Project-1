package edu.westga.cs3211.pirate_ship_inventory_manager.viewModel;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Inventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.InventoryManager;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogChangesInventory;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.LogManager;

/**
 * The InventoryPageWindowViewModel class.
 * 
 * @version Fall 2025
 * @author CS3211
 */
public class InventoryPageWindowViewModel extends SessionViewModel {
	private Inventory inventory;
	private LogChangesInventory logInventory;
	
	/**
	 * The viewmodel the InventoryPageWindowViewModel
	 * 
	 * @author CS3211
	 * @version Fall 2025
	 */
	public InventoryPageWindowViewModel() {
		this.inventory = InventoryManager.getInstance().getInventory();
		this.logInventory = LogManager.getInstance().getLogChangesInventory();
	}
}
