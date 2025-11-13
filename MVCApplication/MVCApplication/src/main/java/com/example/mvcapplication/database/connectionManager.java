package com.example.mvcapplication.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionManager {

    public static Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1/newhr";
        String user = "root";
        String password = "";

        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

    }


}
