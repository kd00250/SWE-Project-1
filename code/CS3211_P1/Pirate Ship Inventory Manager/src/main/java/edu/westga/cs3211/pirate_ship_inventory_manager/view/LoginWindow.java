package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.PageResources;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/** Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class LoginWindow {
	@FXML
    private TextField passwordTextBox;

    @FXML
    private TextField usernameTextBox;
    
    @FXML
    private AnchorPane pane;

    @FXML
    private Button loginButton;

    @FXML
    private Label passwordErrorLabel;

    @FXML
    private Label usernameErrorLabel;
    
    private LoginWindowViewModel vm;

    @FXML
    void validateCredentials(ActionEvent event) {
    	if (!this.vm.validateCredentials()) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Failed to login");
    		alert.setContentText("Incorrect username or password entered. Please try again.");
    		alert.showAndWait();
    	} else {
    		this.closeWindow();
    		this.getLandingPageWindow();
    	}
    }
    
    private void closeWindow() {
		Stage stage = (Stage) (this.pane).getScene().getWindow();
		stage.close();
	}
    
    private void usernameValidation() {
		this.usernameTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.isBlank()) {
				this.usernameErrorLabel.setText("Username cannot be blank");
				return;
			} else {
				this.usernameErrorLabel.setText(""); 
			} 
		});
	}
    
    private void passwordValidation() {
		this.passwordTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.isBlank()) {
				this.passwordErrorLabel.setText("Password cannot be blank");
				return;
			} else {
				this.passwordErrorLabel.setText("");
			}
		});  
	}
    
    private void setUpEnableControls() {
    	this.loginButton.disableProperty().bind(this.usernameTextBox.textProperty().isEmpty().or(this.passwordTextBox.textProperty().isEmpty()));
    }
    
    private void setUpBindings() { 
    	this.vm = new LoginWindowViewModel(); 
    	this.vm.getUsername().bind(this.usernameTextBox.textProperty());
    	this.vm.getPassword().bind(this.passwordTextBox.textProperty());
    }
    
    private void getLandingPageWindow() {
		try {
			Stage stage = (Stage) this.pane.getScene().getWindow();
			LandingPageWindow landingController = ViewSwapper.loadOntoStage(PageResources.LANDING_PAGE, stage, PageResources.LANDING_PAGE_TITLE);
			landingController.setSession(new CurrentSession(this.vm.getUser()));
		} catch (Exception exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
    } 
    
    @FXML
    void initialize() {
    	this.setUpBindings();
    	this.setUpEnableControls();
    	this.usernameValidation();
    	this.passwordValidation();
    	
    	this.loginButton.setOnAction((event) -> {
    		this.validateCredentials(event);
    	});
    }
}
