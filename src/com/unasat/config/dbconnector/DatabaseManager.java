package com.unasat.config.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//database info stored
public class DatabaseManager {
    private String url = "jdbc:mysql://localhost:3306/memoryg";
    private String username = "root";
    private String password = "dKwRaUyYnDeEN0025";

    public DatabaseManager(String url, String username, String password) {
        // Constructor to set the database URL, username, and password
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public DatabaseManager() {
        // Default constructor
    }

    public Connection getConnection() throws SQLException {
        // Establishes a connection to the database using the provided URL, username, and password
        return DriverManager.getConnection(url, username, password);
    }

}
