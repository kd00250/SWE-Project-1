package edu.westga.cs1302.javafx_sample.view;

import edu.westga.cs1302.javafx_sample.viewModel.LoginWindowViewModel;
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
    	
    }
}
