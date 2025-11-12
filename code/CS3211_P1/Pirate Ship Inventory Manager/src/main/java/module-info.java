module edu.westga.cs3211.helloworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens edu.westga.cs3211.pirate_ship_inventory_manager.view to javafx.fxml;
    exports edu.westga.cs3211.pirate_ship_inventory_manager;
}
