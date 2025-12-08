package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.io.IOException;

import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LandingPageWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.Main;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
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
public class LandingPageWindow implements SessionSetter {

	@FXML
	private Button addStockButton;

	@FXML
	private Button reViewStockChangesButton;
    
    @FXML
    private Button viewInventoryButton;

	private LandingPageWindowViewModel landingVM;

	@FXML
	void addStock(ActionEvent event) {
		this.getAddStockWindow();
	}

	@FXML
	void reviewStockChanges(ActionEvent event) {
		this.getReviewStockChangesWindow();
    }
    
    @FXML
    void viewInventory(ActionEvent event) {
    	this.getInventoryPageWindow();
    }
    
    private void getInventoryPageWindow() {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.VIEW_INVENTORY_PAGE));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage setInventoryStage = new Stage();
			setInventoryStage.setTitle(Main.VIEW_INVENTORY_TITLE);
			setInventoryStage.setScene(scene);
			setInventoryStage.initModality(Modality.APPLICATION_MODAL);

			//AddStockWindow addStockCodebehind = (AddStockWindow) loader.getController();
			//addStockCodebehind.bindToAddStockVM(this.vm);  TODO ADD CODEBEHIND WHEN GOTTEN TO IT

			setInventoryStage.showAndWait();
		} catch (IOException error) { 
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
		}
	}

	@FXML
	void initialize() {
		this.landingVM = new LandingPageWindowViewModel();
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
			addStockCodebehind.setSession(this.landingVM.getCurrentSession().getValue());

			setAddStockStage.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
		}
	}

	private void getReviewStockChangesWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.REVIEW_STOCK_CHANGES_PAGE));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage setReviewStockChangesStage = new Stage();
			setReviewStockChangesStage.setTitle(Main.REVIEW_STOCK_CHANGES_TITLE);
			setReviewStockChangesStage.setScene(scene);
			setReviewStockChangesStage.initModality(Modality.APPLICATION_MODAL);

			ReviewStockChangesWindow reviewStockChangesCodebehind = (ReviewStockChangesWindow) loader.getController();
			reviewStockChangesCodebehind.setSession(this.landingVM.getCurrentSession().getValue());   

			setReviewStockChangesStage.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
		}
	}

	@Override
	public void setSession(CurrentSession context) {
		this.landingVM.setCurrentSession(context);
		this.bindToContext();
	}

	private void bindToContext() {
		this.reViewStockChangesButton.disableProperty()
				.bind(this.landingVM.roleProperty().isNotEqualTo(LoginWindowViewModel.QUARTERMASTER_ROLE));
		this.reViewStockChangesButton.setOnAction((event) -> {
			this.reviewStockChanges(event);
		});
		this.addStockButton.setOnAction((event) -> {
			this.addStock(event);
		});
    	this.viewInventoryButton.setOnAction((event) -> {
    		this.viewInventory(event);
    	});
	}

}
