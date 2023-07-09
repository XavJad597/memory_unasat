package com.unasat.config;

import com.unasat.config.dbconnector.DatabaseManager;
import com.unasat.repository.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginManager {

    //Variables
    public static Person player1 = new Person();

    public DatabaseManager databaseManager;
    String stayName;

    //Constructors
    public LoginManager(DatabaseManager loginManager) {
        this.databaseManager = loginManager;
    }

    public LoginManager() {
    }

    // Login to your profile
    public boolean login()throws SQLException {

      Scanner scanner = new Scanner(System.in);

      //give your info
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your password: ");
        String userPassword = scanner.nextLine();

        Connection connection = databaseManager.getConnection();

        // Extract the users' info with parameterized values
        player1 = new Person(userName);
        String lastUserName = player1.getUserName();


        try {
            //query to retrieve player info from database 
            String selectQuery = "SELECT * FROM player WHERE username = ? AND p_password = ?";
            PreparedStatement loginStatement = connection.prepareStatement(selectQuery);
            loginStatement.setString(1, lastUserName);
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





