package com.unasat.repository.entity.person;

import com.unasat.config.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginManager {
    public DatabaseManager databaseManager;

    public LoginManager(DatabaseManager loginManager) {
        this.databaseManager = loginManager;


    }

    // Login to your profile
    public boolean login(String userName, String userPassword)throws SQLException {

      Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        userName = scanner.nextLine();
        System.out.print("Enter your password: ");
        userPassword = scanner.nextLine();

        Connection connection = databaseManager.getConnection();

        // Extract the users' info with parameterized values
        String selectQuery = "SELECT * FROM player WHERE username = ? AND p_password = ?";


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





