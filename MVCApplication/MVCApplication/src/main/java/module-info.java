module com.example.mvcapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.example.mvcapplication;
    requires javafx.base;


    opens com.example.mvcapplication.models to javafx.fxml, javafx.base;
    exports com.example.mvcapplication;
}