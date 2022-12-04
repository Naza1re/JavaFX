module com.example.pogoda {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.management;
    requires org.json;


    opens com.example.pogoda to javafx.fxml;
    exports com.example.pogoda;
}