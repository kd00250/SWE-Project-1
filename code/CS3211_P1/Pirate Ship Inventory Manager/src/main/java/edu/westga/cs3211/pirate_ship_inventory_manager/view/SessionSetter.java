package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;

/**
 * The sesion setter interface.
 * @version Fall 2025
 * @author CS3211
 */
public interface SessionSetter {
	
	/**
	 * Sets current session context.
	 * @param context the session context
	 */
	void setSession(CurrentSession context);
}
