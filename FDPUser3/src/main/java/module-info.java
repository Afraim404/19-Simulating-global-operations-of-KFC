module com.example.fdpuser3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fdpuser3 to javafx.fxml;
    exports com.example.fdpuser3;
}