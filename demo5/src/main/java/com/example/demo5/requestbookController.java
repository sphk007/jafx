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
import java.util.jar.Attributes;

public class requestbookController {

    @FXML
    private Button backtobooks;

    @FXML
    private Label messageaftersubmit;

    @FXML
    private TextField requestauthorname;

    @FXML
    private TextField requestbookname;

    @FXML
    private Button submitforrequest;

    Connection con;
    PreparedStatement pst;

    @FXML
    public void backtobooksOnAction(ActionEvent event) throws IOException {


    }

    @FXML
    public void requestsubmitOnAction(ActionEvent event) {
        String BookName = requestbookname.getText();
        String AuthorName = requestauthorname.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/login","root","$Phk0007");

            pst = con.prepareStatement("insert into (Bookname,Authorname)values(?,?)");
            pst.setString(1,BookName);
            pst.setString(2,AuthorName);
            int status=pst.executeUpdate();

            if (status==1){
                System.out.println("record added");
                requestbookname.setText("");
                requestauthorname.setText("");
                requestbookname.requestFocus();
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
