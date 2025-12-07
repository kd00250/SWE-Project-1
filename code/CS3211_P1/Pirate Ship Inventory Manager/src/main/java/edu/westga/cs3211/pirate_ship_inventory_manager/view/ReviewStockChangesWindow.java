package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * The codebehind for ReviewStockChangesWindow
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class ReviewStockChangesWindow implements SessionSetter {
	@FXML
    private ListView<String> changeResultsListView;

    @FXML
    private ComboBox<String> chooseSortComboBox;

    @FXML
    private ListView<String> crewmateListView;
    
    @FXML
    private DatePicker endDatePicker;
    
    @FXML
    private TextField hoursEndTextBox;

    @FXML
    private TextField hoursStartTextBox;
    
    @FXML
    private TextField minutesEndTextBox;

    @FXML
    private TextField minutesStartTextBox;
    
    @FXML
    private TextField secondsEndTextBox;

    @FXML
    private TextField secondsStartTextBox;

    @FXML
    private Button filterButton;
    
    @FXML
    private Button clearDateButton;
    
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
    void clearDates(ActionEvent event) {
    	this.startDatePicker.setValue(null);
    	this.endDatePicker.setValue(null);
    }
    
    @FXML
    void initialize() {
    	this.reviewVM = new ReviewStockChangesViewModel();
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
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() == null && this.hoursStartTextBox.getText().isEmpty() && this.minutesStartTextBox.getText().isEmpty() && this.secondsStartTextBox.getText().isEmpty()) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartDateFilter(startDateString)));
    		}
    	}
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() != null && this.hoursStartTextBox.getText().isEmpty() && this.minutesStartTextBox.getText().isEmpty() && this.secondsStartTextBox.getText().isEmpty() && this.hoursEndTextBox.getText().isEmpty() && this.minutesEndTextBox.getText().isEmpty() && this.secondsEndTextBox.getText().isEmpty()) {
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
    	this.timeFiltersCall();
    	this.moreTimeFilters();
    }
    
    private void timeFiltersCall() {
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() == null && (!this.hoursStartTextBox.getText().isEmpty() || !this.minutesStartTextBox.getText().isEmpty() || !this.secondsStartTextBox.getText().isEmpty()) && (this.hoursEndTextBox.getText().isEmpty() && this.minutesEndTextBox.getText().isEmpty() && this.secondsEndTextBox.getText().isEmpty())) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartTimeChanges(this.reviewVM.getStartDateFilterForTime(startDateString), this.reviewVM.getHoursStartDate().get(), this.reviewVM.getMinutesStartDate().get(), this.reviewVM.getSecondsStartDate().get())));
    		}
    	}
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() == null && (this.hoursStartTextBox.getText().isEmpty() && this.minutesStartTextBox.getText().isEmpty() && this.secondsStartTextBox.getText().isEmpty()) && (!this.hoursEndTextBox.getText().isEmpty() || !this.minutesEndTextBox.getText().isEmpty() || !this.secondsEndTextBox.getText().isEmpty())) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartTimeChangesForEndTime(this.reviewVM.getStartDateFilterForTime(startDateString), this.reviewVM.getHoursEndDate().get(), this.reviewVM.getMinutesEndDate().get(), this.reviewVM.getSecondsEndDate().get())));
    		}
    	}
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() != null && (this.hoursStartTextBox.getText().isEmpty() && this.minutesStartTextBox.getText().isEmpty() && this.secondsStartTextBox.getText().isEmpty()) && (!this.hoursEndTextBox.getText().isEmpty() || !this.minutesEndTextBox.getText().isEmpty() || !this.secondsEndTextBox.getText().isEmpty())) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		LocalDate endDate = this.endDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
    			String endDateString = endDate.format(formatter); 
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartTimeChangesForEndTime(this.reviewVM.getStartAndEndDateFilterForTime(startDateString, endDateString), this.reviewVM.getHoursEndDate().get(), this.reviewVM.getMinutesEndDate().get(), this.reviewVM.getSecondsEndDate().get())));
    		}
    	}
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() != null && (!this.hoursStartTextBox.getText().isEmpty() || !this.minutesStartTextBox.getText().isEmpty() || !this.secondsStartTextBox.getText().isEmpty()) && (this.hoursEndTextBox.getText().isEmpty() && this.minutesEndTextBox.getText().isEmpty() && this.secondsEndTextBox.getText().isEmpty())) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		LocalDate endDate = this.endDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
    			String endDateString = endDate.format(formatter);
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartTimeChanges(this.reviewVM.getStartAndEndDateFilterForTime(startDateString, endDateString), this.reviewVM.getHoursStartDate().get(), this.reviewVM.getMinutesStartDate().get(), this.reviewVM.getSecondsStartDate().get())));
    		}
    	}
    }
    
    private void moreTimeFilters() {
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() == null && (!this.hoursStartTextBox.getText().isEmpty() || !this.minutesStartTextBox.getText().isEmpty() || !this.secondsStartTextBox.getText().isEmpty()) && (!this.hoursEndTextBox.getText().isEmpty() || !this.minutesEndTextBox.getText().isEmpty() || !this.secondsEndTextBox.getText().isEmpty())) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
    			String startTimeValues = this.reviewVM.getHoursStartDate().get() + "," + this.reviewVM.getMinutesStartDate().get() + "," + this.reviewVM.getSecondsStartDate().get();
    			String endTimeValues = this.reviewVM.getHoursEndDate().get() + "," + this.reviewVM.getMinutesEndDate().get() + "," + this.reviewVM.getSecondsEndDate().get();
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartAndEndTimeChanges(this.reviewVM.getStartDateFilterForTime(startDateString), startTimeValues, endTimeValues)));
    		}
    	}
    	if (this.chooseSortComboBox.getValue().equals("Date") && this.endDatePicker.getValue() != null && (!this.hoursStartTextBox.getText().isEmpty() || !this.minutesStartTextBox.getText().isEmpty() || !this.secondsStartTextBox.getText().isEmpty()) && (!this.hoursEndTextBox.getText().isEmpty() || !this.minutesEndTextBox.getText().isEmpty() || !this.secondsEndTextBox.getText().isEmpty())) {
    		LocalDate startDate = this.startDatePicker.getValue();
    		LocalDate endDate = this.endDatePicker.getValue();
    		if (startDate != null) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    			String startDateString = startDate.format(formatter);
    			String endDateString = endDate.format(formatter);
    			String startTimeValues = this.reviewVM.getHoursStartDate().get() + "," + this.reviewVM.getMinutesStartDate().get() + "," + this.reviewVM.getSecondsStartDate().get();
    			String endTimeValues = this.reviewVM.getHoursEndDate().get() + "," + this.reviewVM.getMinutesEndDate().get() + "," + this.reviewVM.getSecondsEndDate().get();
		        this.changeResultsListView.getItems().setAll(
		            FXCollections.observableArrayList(this.reviewVM.getStartAndEndTimeChanges(this.reviewVM.getStartAndEndDateFilterForTime(startDateString, endDateString), startTimeValues, endTimeValues)));
    		}
    	}
    }
    
    private void setUpTimeFilters() {
    	this.startDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                this.hoursStartTextBox.setDisable(false);
                this.minutesStartTextBox.setDisable(false);
                this.secondsStartTextBox.setDisable(false);
                this.hoursEndTextBox.setDisable(false);
                this.minutesEndTextBox.setDisable(false);
                this.secondsEndTextBox.setDisable(false);
            } else {
                this.hoursStartTextBox.setDisable(true);
                this.minutesStartTextBox.setDisable(true);
                this.secondsStartTextBox.setDisable(true);
                this.hoursStartTextBox.clear();
                this.minutesStartTextBox.clear();
                this.secondsStartTextBox.clear();
                this.hoursEndTextBox.setDisable(true);
                this.minutesEndTextBox.setDisable(true);
                this.secondsEndTextBox.setDisable(true);
                this.hoursEndTextBox.clear();
                this.minutesEndTextBox.clear();
                this.secondsEndTextBox.clear();
            }
        });
    }
    
    private void displayErrorPopup(String message) { 
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait(); 
	}
    
    private void setUpControls() {
    	String[] filters = {"Special Quantity", "Crewmate", "Date"};
    	this.chooseSortComboBox.getItems().addAll(filters);
    	this.changeResultsListView.getItems().addAll(this.reviewVM.getLogChanges());
    	this.chooseSortComboBox.setValue(filters[0]);
    	this.crewmateListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	this.crewmateListView.getItems().addAll(this.reviewVM.getCrewList());
    	this.setupStartTimeBoxes();
    	this.setupEndTimeBoxes();
    	this.startDatePicker.setEditable(false);
    	this.endDatePicker.setEditable(false);
    	this.setUpTimeFilters();
    	
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
    
    private void setupStartTimeBoxes() {
    	this.hoursStartTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.hoursStartTextBox.setText(oldValue);
                return;
            }
            if (!newValue.isEmpty()) {
                try {
                    int value = Integer.parseInt(newValue);
                    if (value > 24) {
                        this.hoursStartTextBox.setText(oldValue);
                    }
                } catch (NumberFormatException ex) {
                    this.hoursStartTextBox.setText(oldValue);
                }
            }
        }); 
        this.minutesStartTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.minutesStartTextBox.setText(oldValue);
                return;
            }
            if (!newValue.isEmpty()) {
                try {
                    int value = Integer.parseInt(newValue);
                    if (value > 60) {
                        this.minutesStartTextBox.setText(oldValue);
                    }
                } catch (NumberFormatException ex) {
                    this.minutesStartTextBox.setText(oldValue);
                }
            }
        }); 
        this.secondsStartTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.secondsStartTextBox.setText(oldValue);
                return;
            }
            if (!newValue.isEmpty()) {
                try {
                    int value = Integer.parseInt(newValue);
                    if (value > 60) {
                        this.secondsStartTextBox.setText(oldValue);
                    }
                } catch (NumberFormatException ex) {
                    this.secondsStartTextBox.setText(oldValue);
                }
            }
        });
    }
    
    private void setupEndTimeBoxes() {
    	this.hoursEndTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.hoursEndTextBox.setText(oldValue);
                return;
            }
            if (!newValue.isEmpty()) {
                try {
                    int value = Integer.parseInt(newValue);
                    if (value > 24) {
                        this.hoursEndTextBox.setText(oldValue);
                    }
                } catch (NumberFormatException ex) {
                    this.hoursEndTextBox.setText(oldValue);
                }
            }
        });
        this.minutesEndTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.minutesEndTextBox.setText(oldValue);
                return;
            }
            if (!newValue.isEmpty()) {
                try {
                    int value = Integer.parseInt(newValue);
                    if (value > 60) {
                        this.minutesEndTextBox.setText(oldValue);
                    }
                } catch (NumberFormatException ex) {
                    this.minutesEndTextBox.setText(oldValue);
                }
            }
        });
        this.secondsEndTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.secondsEndTextBox.setText(oldValue);
                return;
            }
            if (!newValue.isEmpty()) {
                try {
                    int value = Integer.parseInt(newValue);
                    if (value > 60) {
                        this.secondsEndTextBox.setText(oldValue);
                    }
                } catch (NumberFormatException ex) {
                    this.secondsEndTextBox.setText(oldValue);
                }
            }
        });
    }
    
    private void disableAllFilterControls() {
        this.isFlammableCheckBox.setDisable(true);
        this.isLiquidCheckBox.setDisable(true);
        this.isPerishableCheckBox.setDisable(true);
        this.crewmateListView.setDisable(true);
        this.startDatePicker.setDisable(true);
        this.endDatePicker.setDisable(true);
        this.hoursStartTextBox.setDisable(true);
        this.minutesStartTextBox.setDisable(true);
        this.secondsStartTextBox.setDisable(true);
        this.hoursEndTextBox.setDisable(true);
        this.minutesEndTextBox.setDisable(true);
        this.secondsEndTextBox.setDisable(true);
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
    	this.reviewVM.getHoursStartDate().bind(this.hoursStartTextBox.textProperty());
    	this.reviewVM.getMinutesStartDate().bind(this.minutesStartTextBox.textProperty());
    	this.reviewVM.getSecondsStartDate().bind(this.secondsStartTextBox.textProperty());
    	this.reviewVM.getHoursEndDate().bind(this.hoursEndTextBox.textProperty());
    	this.reviewVM.getMinutesEndDate().bind(this.minutesEndTextBox.textProperty());
    	this.reviewVM.getSecondsEndDate().bind(this.secondsEndTextBox.textProperty());
    }
    
       /**
   	   * Provides bindings for the functionality
   	   * 
   	   */
       private void initalizeControls() {
       	this.setUpControls();
       	this.setUpBinds();
       	this.displayAllLogsButton.setOnAction((event) -> {
       		this.displayAllLogs(event);
       	});
       	this.filterButton.setOnAction((event) -> {
       		this.filterResultsListView(event);
       	});
       }

	   @Override
	   public void setSession(CurrentSession context) {
		   this.reviewVM.setCurrentSession(context);
		   this.initalizeControls();
	   }
}
