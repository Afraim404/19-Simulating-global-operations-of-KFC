module com.cse.oop.projectkfc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cse.oop.projectkfc to javafx.fxml;
    exports com.cse.oop.projectkfc;
}