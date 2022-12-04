module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javaproject to javafx.fxml;
    exports sample;
    opens sample to javafx.fxml;
    exports com.example.javaproject;
}