package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.io.IOException;

import edu.westga.cs3211.pirate_ship_inventory_manager.Main;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.LANDING_PAGE));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage setLandingPageStage = new Stage();
			setLandingPageStage.setTitle(Main.LANDING_PAGE_TITLE);
			setLandingPageStage.setScene(scene);
			setLandingPageStage.initModality(Modality.APPLICATION_MODAL);

			LandingPageWindow landingPageCodebehind = (LandingPageWindow) loader.getController();
			landingPageCodebehind.bindToVM(this.vm);

			setLandingPageStage.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
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
