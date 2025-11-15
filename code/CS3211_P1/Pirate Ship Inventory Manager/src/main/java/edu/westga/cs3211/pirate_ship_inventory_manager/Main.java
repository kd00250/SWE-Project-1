package edu.westga.cs3211.pirate_ship_inventory_manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Main Application class.
 * @author CS 3211
 * @version Fall 2025
 */
public class Main extends Application {
	
	public static final String REVIEW_STOCK_CHANGES_TITLE = "SWE 1 Project 1 - Review Stock Changes Page";
	public static final String REVIEW_STOCK_CHANGES_PAGE = "view/ReviewStockChangesWindow.fxml";

	public static final String PICK_STORAGE_PAGE_TITLE = "SWE 1 Project 1 - Pick Storage Page";
	public static final String PICK_STORAGE_PAGE = "view/PickStorageWindow.fxml";
	
	public static final String ADD_STOCK_PAGE_TITLE = "SWE 1 Project 1 - Add Stock Page";
	public static final String ADD_STOCK_PAGE = "view/AddStockWindow.fxml";
	
	public static final String LANDING_PAGE_TITLE = "SWE 1 Project 1 - Landing Page";
	public static final String LANDING_PAGE = "view/LandingPageWindow.fxml";
	
	private static final String WINDOW_TITLE = "SWE 1 Project 1";
	private static final String GUI_RESOURCE = "view/LoginWindow.fxml";

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = this.loadGui();
			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_TITLE);
			primaryStage.show();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(GUI_RESOURCE));
		return (Pane) loader.load();
	}

	/**
	 * Entry point for the application
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
