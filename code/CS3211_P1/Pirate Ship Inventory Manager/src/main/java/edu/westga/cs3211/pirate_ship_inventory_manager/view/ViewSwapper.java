package edu.westga.cs3211.pirate_ship_inventory_manager.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class ViewSwapper {
	public static <T> T loadOntoStage(String fxmlPath, Stage stage, String title) throws IOException {
		if (fxmlPath == null) {
			throw new IllegalArgumentException("FXML path must be non null");
		}

		if (fxmlPath.isEmpty()) {
			throw new IllegalArgumentException("fxmlpath cannot be empty");
		}

		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		if(title == null) {
			throw new IllegalArgumentException("Title cannot be null");
		}
		
		if (title.isEmpty()) {
			throw new IllegalArgumentException("Title cannot be empty");
		}

		FXMLLoader loader = new FXMLLoader(ViewSwapper.class.getResource(fxmlPath));
		Parent root = loader.load();
		T controller = loader.getController();

		stage.setScene(new Scene(root));
		stage.centerOnScreen();
		stage.setTitle(title);
		stage.show();

		return controller;
	}
}
