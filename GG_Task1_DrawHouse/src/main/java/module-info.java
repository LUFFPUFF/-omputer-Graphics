module com.example.gg_task1_drawhouse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gg_task1_drawhouse to javafx.fxml;
    exports com.example.gg_task1_drawhouse;
}