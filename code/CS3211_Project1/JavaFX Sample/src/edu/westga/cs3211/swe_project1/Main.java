package edu.westga.cs3211.swe_project1;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Entry point for the program​
 *​
 * @author CS3211​
 * @version Fall 2025​
 */
public class Main extends Application {
	public static final String PICK_STORAGE_PAGE_TITLE = "SWE 1 Project 1 - Pick Storage Page";
	public static final String PICK_STORAGE_PAGE = "view/PickStorageWindow.fxml";
	
	public static final String ADD_STOCK_PAGE_TITLE = "SWE 1 Project 1 - Add Stock Page";
	public static final String ADD_STOCK_PAGE = "view/AddStockWindow.fxml";
	
	public static final String LANDING_PAGE_TITLE = "SWE 1 Project 1 - Landing Page";
	public static final String LANDING_PAGE = "view/LandingPageWindow.fxml";
	
	private static final String WINDOW_TITLE = "SWE 1 Project 1";
	private static final String GUI_RESOURCE = "view/LoginWindow.fxml";
	  
	/** JavaFX entry point.​
	  *​
	  * @precondition none​
	  * @postcondition none​
	  *​
	  * @throws IOException unable to load fxml for MainWindow​
	  */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource(Main.GUI_RESOURCE));
		Scene scene = new Scene(parent);
		primaryStage.setTitle(Main.WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/** Primary Java entry point.​
	  *​
	  * @precondition none​
	  * @postcondition none​
	  *​
	  * @param args command line arguments​
	  */
	public static void main(String[] args) {
		Main.launch(args);
	}

}
