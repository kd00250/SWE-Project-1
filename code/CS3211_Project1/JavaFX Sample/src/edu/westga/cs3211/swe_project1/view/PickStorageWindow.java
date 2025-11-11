package edu.westga.cs3211.swe_project1.view;

import edu.westga.cs3211.swe_project1.viewModel.AddStockWindowViewModel;
import edu.westga.cs3211.swe_project1.viewModel.LoginWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * The codebehind for pickStorageWindow
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class PickStorageWindow {
	@FXML
    private Button boxesButton;

    @FXML
    private Button shelvesButton;

    @FXML
    private Button specialStorage1Button;

    @FXML
    private Button specialStorage2Button;
    
    private LoginWindowViewModel vm;

    @FXML
    void addStockToBoxes(ActionEvent event) {

    }

    @FXML
    void addStockToShelves(ActionEvent event) {

    }

    @FXML
    void addStockToSpecialStorage1(ActionEvent event) {

    }

    @FXML
    void addStockToSpecialStorage2(ActionEvent event) {

    }
    
    /**
     * provides the bindings for the view models
     * 
     * @param vm the login vm
     * @param addStockVM the addStockVM
     */
    public void bindToPickStorageVM(LoginWindowViewModel vm, AddStockWindowViewModel addStockVM) {
    	//this.reViewStockChangesButton.disableProperty().bind(vm.isQuartermasterProperty().not());
    	
    }
}
