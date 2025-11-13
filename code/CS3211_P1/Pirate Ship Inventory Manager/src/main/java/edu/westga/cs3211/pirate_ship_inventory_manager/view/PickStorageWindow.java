package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The codebehind for pickStorageWindow
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class PickStorageWindow {
	@FXML
    private Button addToStorageButton;

    @FXML
    private ComboBox<String> normalStorageComboBox;

    @FXML
    private ComboBox<String> specialStorageComboBox;
    
    @FXML
    private AnchorPane pane;
    
    private LoginWindowViewModel vm;
    private AddStockWindowViewModel addStockVM;

    @FXML
    void addToStorage(ActionEvent event) {
    	if (this.normalStorageComboBox.isDisabled()) {
    		this.addStockVM.addStockToCompartment(this.specialStorageComboBox.getValue(), this.addStockVM.createStock());
    		this.displaySuccessPopup("Item successfully added to " + this.specialStorageComboBox.getValue());
    		this.closeWindow();
    	} else {
    		this.addStockVM.addStockToCompartment(this.normalStorageComboBox.getValue(), this.addStockVM.createStock());
    		this.displaySuccessPopup("Item successfully added to " + this.normalStorageComboBox.getValue());
    		this.closeWindow();
    	}
    }
    
    private void closeWindow() {
		Stage stage = (Stage) (this.pane).getScene().getWindow();
		stage.close();
	}
    
    private void displaySuccessPopup(String message) {  
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText(message);
		alert.showAndWait();
	}
    
    private void setUpControls(AddStockWindowViewModel addStockVM) {
    	this.normalStorageComboBox.disableProperty().bind(addStockVM.getIsFlammableProperty()
    			.or(addStockVM.getIsLiquidProperty()).or(addStockVM.getIsPerishableProperty()));
    	
    	this.specialStorageComboBox.disableProperty().bind(addStockVM.getIsFlammableProperty().not()
    			.and(addStockVM.getIsLiquidProperty().not()).and(addStockVM.getIsPerishableProperty().not()));
    	
    	this.addToStorageButton.disableProperty().bind(Bindings.isNull(this.normalStorageComboBox.valueProperty())
    			.and(Bindings.isNull(this.specialStorageComboBox.valueProperty())));
    	
    	ObservableList<String> observableNormalCompartments = FXCollections.observableArrayList(addStockVM.getNormalStorage());
    	ObservableList<String> observableSpecialCompartments = FXCollections.observableArrayList(addStockVM.getSpecialStorageForStock(addStockVM.createStock()));
    	this.normalStorageComboBox.setItems(observableNormalCompartments); 
    	this.specialStorageComboBox.setItems(observableSpecialCompartments);
    }
    
    /**
     * provides the bindings for the view models
     * 
     * @param vm the login vm
     * @param addStockVM the addStockVM
     */
    public void bindToPickStorageVM(LoginWindowViewModel vm, AddStockWindowViewModel addStockVM) {
    	this.addStockVM = addStockVM;
    	this.setUpControls(addStockVM);
   
    }
}
