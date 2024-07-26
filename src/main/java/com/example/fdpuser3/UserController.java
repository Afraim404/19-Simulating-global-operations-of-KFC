package com.example.fdpuser3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserController {
    @javafx.fxml.FXML
    public void onlineCustomer(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("OnlineCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 650);
        Stage stage = new Stage();
        stage.setTitle("Online Customer");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void foodDeliveryPartner(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("FoodDeliveryPersonnel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 650);
        Stage stage = new Stage();
        stage.setTitle("Food Delivery Personnel");
        stage.setScene(scene);
        stage.show();
    }
}
