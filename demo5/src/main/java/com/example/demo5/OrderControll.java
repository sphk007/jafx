package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderControll {

    @FXML
    private Button OK;

    @FXML
    void okOnAction(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("subtle.fxml"));
        Stage window=(Stage) OK.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));

    }

}
