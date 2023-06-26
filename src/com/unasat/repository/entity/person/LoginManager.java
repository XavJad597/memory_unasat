package com.unasat.repository.entity.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.unasat.config.DatabaseManager;

public class LoginManager {
    private DatabaseManager databaseManager;

    public LoginManager(DatabaseManager loginManager) {
        this.databaseManager = loginManager;
    }

    // Login to your profile
    public boolean login(String userName, String userPassword) {
        // Extract the users' info with parameterized values
        String selectQuery = "SELECT * FROM player WHERE username = ? AND p_password = ?";

        // Get the connection from the DatabaseManager instance
        Connection connection = databaseManager.getConnection();

        try {
            PreparedStatement loginStatement = connection.prepareStatement(selectQuery);
            loginStatement.setString(1, userName);
            loginStatement.setString(2, userPassword);

            ResultSet resultSet = loginStatement.executeQuery();
            if (resultSet.next()) {
                // User exists and credentials are correct
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error: Failed to execute the login query.");
            e.printStackTrace();
        }

        return false;
    }
}


