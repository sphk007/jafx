package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class requestController {

    @FXML
    private Button backtobooks;

    @FXML
    private Label messageaftersubmit;

    @FXML
    private Button submitforrequest;

    @FXML
    private TextField usermobile;

    @FXML
    private TextField username;

    @FXML
    private TextField userproduct;

    @FXML
    private TextField userquantity;

    Connection con;
    PreparedStatement pst;

    @FXML
    void backtobooksOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("showbook.fxml"));
        Stage window=(Stage) backtobooks.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));

    }

    @FXML
    void requestsubmitOnAction(ActionEvent event) {

        String name = username.getText();

        String mobile =usermobile.getText();
        String product = userproduct.getText();
        String quantity = userquantity.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/login","root","$Phk0007");

            pst = con.prepareStatement("insert into productrequest(name,mobile,product,quantity)values(?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,mobile);
            pst.setString(3,product);
            pst.setString(4,quantity);

            int status=pst.executeUpdate();

            if (status==1){
                System.out.println("record added");
                username.setText("");
                usermobile.setText("");
                userproduct.setText("");
                userquantity.setText("");
                username.requestFocus();

                messageaftersubmit.setText("request submitted");
            }else {
                System.out.println("record failed");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
