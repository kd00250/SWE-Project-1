package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.util.ArrayList;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.InventoryPageWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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
	
	private InventoryPageWindowViewModel inventoryVM;
	
	@FXML
	private AnchorPane pane;
	
	@FXML
	void initialize() {
		this.inventoryVM = new InventoryPageWindowViewModel();
	}
	
	@FXML
	private void onHomeClick(ActionEvent event) {
		this.getLandingPage();
	}
	
	private void getLandingPage() {
		try {
			Stage stage = (Stage) this.pane.getScene().getWindow();
			LandingPageWindow landingController = ViewSwapper.loadPageFromStage(PageResources.LANDING_PAGE, stage,
					PageResources.LANDING_PAGE_TITLE);
			landingController.setSession(this.inventoryVM.getCurrentSession().getValue());
		} catch (Exception exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load landing page.");
			alert.showAndWait();
			exception.printStackTrace();
		}
	}
	
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
		this.inventoryVM.setCurrentSession(context);
		this.initializeControls();
	}
	
	private void initializeControls() {
		this.setUpStockTypeComboBox();
		return;
	}
	
	private void setUpStockTypeComboBox() {
		if (this.getUserRole().equals("Cook")) {
			this.stockTypeComboBox.getItems().add(StockType.FOOD);
		}
	}

	private String getUserRole() {
		return this.inventoryVM.getCurrentSession().get().getUser().getRole();
	}
}
