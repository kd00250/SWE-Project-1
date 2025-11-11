package edu.westga.cs3211.swe_project1.view;

import java.io.IOException;

import edu.westga.cs3211.swe_project1.Main;
import edu.westga.cs3211.swe_project1.viewModel.AddStockWindowViewModel;
import edu.westga.cs3211.swe_project1.viewModel.LoginWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    
    /**
	 * Provides bindings for the functionality
	 * 
	 * @param vm the vm
	 */
    public void bindToAddStockVM(LoginWindowViewModel vm) {
    	this.expirationDateTextBox.disableProperty().bind(this.addStockVM.getIsFlammableProperty().not()
    			.or(this.addStockVM.getIsLiquidProperty().not()).or(this.addStockVM.getIsPerishableProperty().not()));
    	this.addStockButton.setOnAction((event) -> {
    		this.addStock(event);
    	});
    }
}
