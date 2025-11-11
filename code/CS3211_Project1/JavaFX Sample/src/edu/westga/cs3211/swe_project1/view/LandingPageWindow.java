package edu.westga.cs3211.swe_project1.view;

import edu.westga.cs3211.swe_project1.viewModel.LoginWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    
    @FXML
    void addStock(ActionEvent event) {
    	//
    }

    @FXML
    void reviewStockChanges(ActionEvent event) {
    	//
    }
    
    /**
     * Provides bindings for functionality
     * 
     * @param vm the vm
     */
    public void bindToVM(LoginWindowViewModel vm) {
    	this.reViewStockChangesButton.disableProperty().bind(vm.isQuartermasterProperty().not());
    }
}
