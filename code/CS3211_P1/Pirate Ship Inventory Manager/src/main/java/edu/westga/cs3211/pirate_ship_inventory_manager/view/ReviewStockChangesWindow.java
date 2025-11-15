package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * The codebehind for ReviewStockChangesWindow
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class ReviewStockChangesWindow {
	@FXML
    private ListView<?> changeResultsListView;

    @FXML
    private ComboBox<?> chooseSortComboBox;

    @FXML
    private ComboBox<?> crewmateComboBox;

    @FXML
    private TextField endDateTextBox;

    @FXML
    private Button filterButton;

    @FXML
    private CheckBox isFlammableCheckBox;

    @FXML
    private CheckBox isLiquidCheckBox;

    @FXML
    private CheckBox isPerishableCheckBox;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField startDateTextBox;
    
    private LoginWindowViewModel vm;

    @FXML
    void filterResultsListView(ActionEvent event) {

    }
    
    /**
   	 * Provides bindings for the functionality
   	 * 
   	 * @param vm the vm
   	 */
       public void bindToReviewStockChangesVM(LoginWindowViewModel vm) {
       	this.vm = vm;
//       	this.setUpBindings();
//       	this.setUpControls();
//       	this.addStockButton.setOnAction((event) -> {
//       		this.addStock(event);
//       	});
//       }
       }
}
