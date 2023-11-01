module com.example.gg_task1_pandaandbamboo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.gg_task1_pandaandbamboo to javafx.fxml;
    exports form;
    opens form to javafx.fxml;
    exports animal;
    opens animal to javafx.fxml;
    exports gui;
    opens gui to javafx.fxml;
}