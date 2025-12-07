package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.AddStockWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.Main;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
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
public class AddStockWindow implements SessionSetter {
	@FXML
	private Button addStockButton;

	@FXML
	private ComboBox<String> conditionComboBox;

    @FXML
    private DatePicker expirationDatePicker;

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

	private AddStockWindowViewModel addStockVM;

    @FXML
    void addStock(ActionEvent event) {
    	if (this.addStockVM.createStock().getHasSpecialQualities() && !this.addStockVM.specialStorageHasFreeSpace(this.addStockVM.createStock())) {
    		this.displayErrorPopup("There is no compartment currently available to store stock \n with indicated special quantity. "
    				+ "\nPlease reassess the quantity entered and try again.");
    	} else if (!this.addStockVM.createStock().getHasSpecialQualities() && !this.addStockVM.normalStorageHasFreeSpace(this.addStockVM.createStock())) {
    		this.displayErrorPopup("There is no compartment currently available to store stock \n with indicated quantity. "
    				+ "\nPlease reassess the quantity entered and try again.");
    	} else {
    	this.getPickStorageWindow();
    	}
    }
    
	@FXML
	void initialize() {
		this.addStockVM = new AddStockWindowViewModel();
	}

    private void displayErrorPopup(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait();
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
			pickStorageCodebehind.bindToPickStorageVM(this.addStockVM.getCurrentSession().getValue(), this.addStockVM);

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
    	this.conditionComboBox.setValue(conditions[0]);
    	this.addStockVM.getCondition().bind(this.conditionComboBox.valueProperty());
    	this.addStockVM.getName().bind(this.nameTextBox.textProperty());
    	this.quantityTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
    	    if (!newValue.matches("^$|^[1-9][0-9]*$")) {
    	        this.quantityTextBox.setText(oldValue);
    	    }
    	});
    	
    	this.isPerishableCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
    		if (!newValue) {
    			this.expirationDatePicker.setValue(null);
    		}
    	});
    	 
    	this.expirationDatePicker.setDayCellFactory(param -> new DateCell() {
    		@Override
    		public void updateItem(LocalDate date, boolean empty) {
    			super.updateItem(date, empty);
    			setDisable(empty || date.compareTo(LocalDate.now()) < 0);
    		}
    	});
    	this.expirationDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                String dateString = newValue.format(formatter);
                this.addStockVM.getExpirationDate().set(dateString);
            } else {
                this.addStockVM.getExpirationDate().set(""); 
            }
        });
    	this.addStockVM.getQuantity().bind(this.quantityTextBox.textProperty());
    	this.addStockVM.getIsFlammableProperty().bind(this.isFlammableCheckBox.selectedProperty());
    	this.addStockVM.getIsLiquidProperty().bind(this.isLiquidcheckBox.selectedProperty());
    	this.addStockVM.getIsPerishableProperty().bind(this.isPerishableCheckBox.selectedProperty());
    } 
    
    private void setUpControls() {
    	this.expirationDatePicker.setEditable(false);
    	this.expirationDatePicker.disableProperty().bind(this.isPerishableCheckBox.selectedProperty().not());
    	this.addStockButton.disableProperty().bind(this.nameTextBox.textProperty().isEmpty()
    			.or(this.quantityTextBox.textProperty().isEmpty()).or(this.expirationDatePicker.disabledProperty().not()
    	                .and(this.expirationDatePicker.valueProperty().isNull())));
    }
    
    /**
	 * Provides bindings for the functionality
	 * 
	 * @param vm the vm
	 */
    public void bindToAddStockVM(LoginWindowViewModel vm) {
    	this.vm = vm;
    	this.setUpBindings();
    	this.setUpControls();
    	this.addStockButton.setOnAction((event) -> {
    		this.addStock(event);
    	});
    }
}
