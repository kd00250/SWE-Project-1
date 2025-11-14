package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.io.IOException;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The codebehind the landingPageWindow of the application
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class LandingPageWindow {

	@FXML
    private Button addStockButton;

    @FXML
    private Button reViewStockChangesButton;
    
    private LoginWindowViewModel vm;
    
    @FXML
    void addStock(ActionEvent event) {
    	this.getAddStockWindow();
    }

    @FXML
    void reviewStockChanges(ActionEvent event) {
    	//
    }
    
    private void getAddStockWindow() {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.ADD_STOCK_PAGE));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage setAddStockStage = new Stage();
			setAddStockStage.setTitle(Main.ADD_STOCK_PAGE_TITLE);
			setAddStockStage.setScene(scene);
			setAddStockStage.initModality(Modality.APPLICATION_MODAL);

			AddStockWindow addStockCodebehind = (AddStockWindow) loader.getController();
			addStockCodebehind.bindToAddStockVM(this.vm);

			setAddStockStage.showAndWait();
		} catch (IOException error) { 
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
		}
    }
    
    /**
     * Provides bindings for functionality
     * 
     * @param vm the vm
     */
    public void bindToVM(LoginWindowViewModel vm) {
    	this.vm = vm;
    	this.reViewStockChangesButton.disableProperty().bind(vm.isQuartermasterProperty().not());
    	this.addStockButton.setOnAction((event) -> {
    		this.addStock(event);
    	});
    }
}
