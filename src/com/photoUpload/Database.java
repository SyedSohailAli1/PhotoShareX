package com.photoUpload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection createDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/PhotoDb";
            String username = "root";
            String password = "wq26jx7866";
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Jdbc Driver not found", e);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create Database Connection", e);
        }
    }
}