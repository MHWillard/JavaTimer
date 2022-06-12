module com.example.javatimer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javatimer to javafx.fxml;
    exports com.example.javatimer;
}