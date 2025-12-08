package edu.westga.cs3211.pirate_ship_inventory_manager.view;


import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LandingPageWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.LoginWindowViewModel;
import edu.westga.cs3211.pirate_ship_inventory_manager.viewModel.PageResources;
import edu.westga.cs3211.pirate_ship_inventory_manager.model.session.CurrentSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
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
	private AnchorPane pane;

	@FXML
	private Button reViewStockChangesButton;
    
    @FXML
    private Button viewInventoryButton;

	private LandingPageWindowViewModel landingVM;

	@FXML
	private void addStock(ActionEvent event) {
		this.getAddStockWindow();
	}

	@FXML
	private void reviewStockChanges(ActionEvent event) {
		this.getReviewStockChangesWindow();
    }
    
    @FXML
    private void viewInventory(ActionEvent event) {
    	this.getInventoryPageWindow();
    }
    
    @FXML
    private void onLogoutClick(ActionEvent event) {
    	this.getLoginPageWindow();
    }
    
    private void getInventoryPageWindow() {
		try {
			Stage stage = (Stage) this.pane.getScene().getWindow();
			//add swap here like below.
			ViewSwapper.loadPageFromStage(PageResources.VIEW_INVENTORY_PAGE, stage, PageResources.VIEW_INVENTORY_TITLE);
		} catch (Exception exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load inventory page.");
			alert.showAndWait();
		    exception.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		this.landingVM = new LandingPageWindowViewModel();
	}

	private void getAddStockWindow() {
		try {
			Stage stage = (Stage) this.pane.getScene().getWindow();
			AddStockWindow addStockController = ViewSwapper.loadPageFromStage(PageResources.ADD_STOCK_PAGE, stage, PageResources.ADD_STOCK_PAGE_TITLE);
			addStockController.setSession(this.landingVM.getCurrentSession().getValue());
		} catch (Exception exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load add stock page.");
			alert.showAndWait();
		    exception.printStackTrace();
		}
	}

	private void getReviewStockChangesWindow() {
		try {
			Stage stage = (Stage) this.pane.getScene().getWindow();
			ReviewStockChangesWindow reviewStockController = ViewSwapper.loadPageFromStage(PageResources.REVIEW_STOCK_CHANGES_PAGE, stage, PageResources.REVIEW_STOCK_CHANGES_TITLE);
			reviewStockController.setSession(this.landingVM.getCurrentSession().getValue());
		} catch (Exception exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load stock changes window");
			alert.showAndWait();
		    exception.printStackTrace();
		}
	}
	
	private void getLoginPageWindow() {
		try {
			Stage stage = (Stage) this.pane.getScene().getWindow();
			ViewSwapper.loadPageFromStage(PageResources.LOGIN_PAGE, stage, PageResources.WINDOW_TITLE);
		} catch (Exception exception) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load login page");
			alert.showAndWait();
		    exception.printStackTrace();
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
