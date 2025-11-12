package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.io.IOException;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The codebehind the addStockWindow of the application
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class AddStockWindow {
	@FXML
    private Button addStockButton;

    @FXML
    private ComboBox<String> conditionComboBox;

    @FXML
    private TextField expirationDateTextBox;

    @FXML
    private TextField nameTextBox;
    
    @FXML
    private CheckBox isFlammableCheckBox;

    @FXML
    private CheckBox isLiquidcheckBox;

    @FXML
    private CheckBox isPerishableCheckBox;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField quantityTextBox;
    
    private LoginWindowViewModel vm;
    private AddStockWindowViewModel addStockVM;

    @FXML
    void addStock(ActionEvent event) {
    	this.getPickStorageWindow();
    }
    
    private void getPickStorageWindow() {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.PICK_STORAGE_PAGE));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage setPickStorageStage = new Stage();
			setPickStorageStage.setTitle(Main.PICK_STORAGE_PAGE_TITLE);
			setPickStorageStage.setScene(scene);
			setPickStorageStage.initModality(Modality.APPLICATION_MODAL);

			PickStorageWindow pickStorageCodebehind = (PickStorageWindow) loader.getController();
			pickStorageCodebehind.bindToPickStorageVM(this.vm, this.addStockVM);

			setPickStorageStage.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
		}
    }
    
    private void setUpBindings() {
    	this.addStockVM = new AddStockWindowViewModel();
    	String [] conditions = {"perfect", "usable", "unsuable"};
    	this.conditionComboBox.getItems().addAll(conditions);
    	this.addStockVM.getCondition().bind(this.conditionComboBox.valueProperty());
    	this.addStockVM.getName().bind(this.nameTextBox.textProperty());
    	this.addStockVM.getQuantity().bind(this.quantityTextBox.textProperty());
    	this.addStockVM.getIsFlammableProperty().bind(this.isFlammableCheckBox.selectedProperty());
    	this.addStockVM.getIsLiquidProperty().bind(this.isLiquidcheckBox.selectedProperty());
    	this.addStockVM.getIsPerishableProperty().bind(this.isPerishableCheckBox.selectedProperty());
    	this.addStockVM.getExpirationDate().bind(this.expirationDateTextBox.textProperty());
    }
    
    /**
	 * Provides bindings for the functionality
	 * 
	 * @param vm the vm
	 */
    public void bindToAddStockVM(LoginWindowViewModel vm) {
    	this.setUpBindings();
    	this.expirationDateTextBox.disableProperty().bind(this.isPerishableCheckBox.selectedProperty().not());
    	this.addStockButton.setOnAction((event) -> {
    		this.addStock(event);
    	});
    }
}
