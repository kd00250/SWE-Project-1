package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.ReviewStockChangesViewModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;

/**
 * The codebehind for ReviewStockChangesWindow
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class ReviewStockChangesWindow {
	@FXML
    private ListView<String> changeResultsListView;

    @FXML
    private ComboBox<String> chooseSortComboBox;

    @FXML
    private ListView<String> crewmateListView;
    
    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Button filterButton;
    
    @FXML
    private Button displayAllLogsButton;

    @FXML
    private CheckBox isFlammableCheckBox;

    @FXML
    private CheckBox isLiquidCheckBox;

    @FXML
    private CheckBox isPerishableCheckBox;

    @FXML
    private AnchorPane pane;

    @FXML
    private DatePicker startDatePicker;
    
    private ReviewStockChangesViewModel reviewVM;
    
    @FXML
    void displayAllLogs(ActionEvent event) {
    	this.changeResultsListView.getItems().setAll(
    			FXCollections.observableArrayList(this.reviewVM.getLogChanges()));
    }

    @FXML
    void filterResultsListView(ActionEvent event) {
    	if (this.chooseSortComboBox.getValue().equals("Crewmate")) {
    		 ArrayList<String> selectedCrewmates = new ArrayList<>(this.crewmateListView.getSelectionModel().getSelectedItems());
    	        
    	        this.changeResultsListView.getItems().setAll(
    	            FXCollections.observableArrayList(this.reviewVM.getCrewmateFilter(selectedCrewmates)));
    	}
    	if (this.chooseSortComboBox.getValue().equals("Special Quantity")) {
	        this.changeResultsListView.getItems().setAll(
	            FXCollections.observableArrayList(this.reviewVM.getSpecialQuantityFilter(this.reviewVM.getIsFlammableProperty().getValue(), this.reviewVM.getIsLiquidProperty().getValue(), this.reviewVM.getIsPerishableProperty().getValue())));
    	}
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() == null) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartDateFilter(startDateString)));
    		}
    	}
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() != null) {
    	    LocalDate startDate = this.startDatePicker.getValue();
    	    LocalDate endDate = this.endDatePicker.getValue();
    	    if (endDate.isBefore(startDate)) {
    	          this.displayErrorPopup("End date cannot be before start date");
    	    } else {
    	          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	          String startDateString = startDate.format(formatter);
    	          String endDateString = endDate.format(formatter);
    	          this.changeResultsListView.getItems().setAll(
    	              FXCollections.observableArrayList(this.reviewVM.getStartAndEndDateFilter(startDateString, endDateString)));
    	        }
    	}
    }   
    
    private void displayErrorPopup(String message) { 
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait(); 
	}
    
    private void setUpControls() {
    	this.reviewVM = new ReviewStockChangesViewModel();
    	String[] filters = {"Special Quantity", "Crewmate", "Date"};
    	this.chooseSortComboBox.getItems().addAll(filters);
    	this.changeResultsListView.getItems().addAll(this.reviewVM.getLogChanges());
    	this.chooseSortComboBox.setValue(filters[0]);
    	this.crewmateListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	this.crewmateListView.getItems().addAll(this.reviewVM.getCrewList());
    	this.startDatePicker.setEditable(false);
    	this.endDatePicker.setEditable(false);
    	
        this.disableAllFilterControls();
        
        this.chooseSortComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.updateControlStates(newValue);
        });
        
        this.startDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
        	boolean hasStartDate = newValue != null;
        	this.endDatePicker.setDisable(!hasStartDate || !this.chooseSortComboBox.getValue().equals("Date"));
        	
        	if (newValue == null) {
                this.endDatePicker.setValue(null);
            }
        });
        
        this.updateControlStates(this.chooseSortComboBox.getValue());
    	
    }
    
    private void disableAllFilterControls() {
        this.isFlammableCheckBox.setDisable(true);
        this.isLiquidCheckBox.setDisable(true);
        this.isPerishableCheckBox.setDisable(true);
        this.crewmateListView.setDisable(true);
        this.startDatePicker.setDisable(true);
        this.endDatePicker.setDisable(true);
    }

    private void updateControlStates(String selectedFilter) {
        this.disableAllFilterControls();
        
        switch (selectedFilter) {
            case "Special Quantity":
                this.isFlammableCheckBox.setDisable(false);
                this.isLiquidCheckBox.setDisable(false);
                this.isPerishableCheckBox.setDisable(false);
                break;
                
            case "Crewmate":
                this.crewmateListView.setDisable(false);
                break;
                
            case "Date":
            	this.startDatePicker.setDisable(false);
            	this.endDatePicker.setDisable(true);

                break;
                
            default:
                break;
        }
        
        if (!selectedFilter.equals("Date")) {
        	this.startDatePicker.setValue(null);
        	this.endDatePicker.setValue(null);
        }
    }
    
    private void setUpBinds() {
    	this.reviewVM.getIsFlammableProperty().bind(this.isFlammableCheckBox.selectedProperty());
    	this.reviewVM.getIsLiquidProperty().bind(this.isLiquidCheckBox.selectedProperty());
    	this.reviewVM.getIsPerishableProperty().bind(this.isPerishableCheckBox.selectedProperty());
    }
    
       /**
   	   * Provides bindings for the functionality
   	   * 
   	   */
       public void bindToReviewStockChangesVM() {
       	this.setUpControls();
       	this.setUpBinds();
       	this.displayAllLogsButton.setOnAction((event) -> {
       		this.displayAllLogs(event);
       	});
       	this.filterButton.setOnAction((event) -> {
       		this.filterResultsListView(event);
       	});
       }
}
