package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * The codebehind for InventoryPageWindow
 * 
 * @author CS 3211
 * @version Fall 2025
 */
public class InventoryPageWindow implements SessionSetter {

	@FXML
	private ComboBox<StockType> stockTypeComboBox;
	
	@FXML
	private Button checkInventoryButton;
	
	@FXML
	private ListView<Stock> availableStocksListView;
	
	@FXML
	private TextField quantityToTakeTextField;
	
	@FXML
	private Button takeStockButton;
	
	@FXML
	void checkInventory(ActionEvent event) {
				// TODO Check Inventory if StockType Exists
    }
	
	@FXML
	void takeStock(ActionEvent event) {
				// TODO Check Inventory if StockType Exists
    }
	
	private void displayErrorPopup(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	@Override
	public void setSession(CurrentSession context) {
		// TODO Auto-generated method stub
	
	}

}
