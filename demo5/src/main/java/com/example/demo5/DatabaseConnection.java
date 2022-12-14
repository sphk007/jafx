package com.example.demo5;
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "login";
        String databaseUser = "root";
        String databasePassword= "$Phk0007";
        String url="jdbc:mysql://localhost/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}