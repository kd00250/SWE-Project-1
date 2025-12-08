package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.Stock;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.StockType;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.InventoryPageWindowViewModel;
import javafx.beans.binding.Bindings;
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
		this.bindControls();
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
		if (!this.inventoryVM.isStockTypeInInventory()) {
			this.displayErrorPopup("Inventory does not contain any Stock of Type" + this.inventoryVM.getStockTypeProperty());
		} else {
			this.availableStocksListView.getItems().addAll(this.inventoryVM.getStockInInventory());
		}
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
	
	private void bindControls() {
		this.inventoryVM.getStockTypeProperty().bind(this.stockTypeComboBox.valueProperty());
		
		this.quantityToTakeTextField.textProperty().addListener((observable, oldValue, newText) -> {
            try {
            	var newValue = Integer.parseInt(newText);
            	this.inventoryVM.getQuantityToTake().set(newValue);
            } catch (NumberFormatException exc) {
            	this.inventoryVM.getQuantityToTake().set(0);
            }
        });
		
		this.availableStocksListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			this.inventoryVM.getSelectedStock().set(newValue);
		});
	}
	
	private void initializeControls() {
		this.setUpStockTypeComboBox();
		this.setUpQuantityToTakeLimits();
		this.disableTakeStockButton();
	}
	
	private void setUpStockTypeComboBox() {
		if (this.getUserRole().equals("Cook")) {
			this.stockTypeComboBox.getItems().add(StockType.FOOD);
		}
	}

	private String getUserRole() {
		return this.inventoryVM.getCurrentSession().get().getUser().getRole();
	}
	
	private void setUpQuantityToTakeLimits() {
		this.quantityToTakeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("^$|^[1-9][0-9]*$")) {
				this.quantityToTakeTextField.setText(oldValue);
			}
		});
	}
	
	private void disableTakeStockButton() {
		this.takeStockButton.disableProperty().bind(Bindings.createBooleanBinding(() -> !this.inventoryVM.isQuantityToTakeValid(), this.inventoryVM.getQuantityToTake()));
	}
}
