package edu.westga.cs3211.swe_project1.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    void addStock(ActionEvent event) {

    }
}
