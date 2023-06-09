package com.unasat.config;

import com.unasat.config.dbconnector.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
    Connection connection;

    public SignUp() {
    }

    //Signup method
    public void signUp() throws SQLException {
        // player info
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Sign up");

       // enter your info
        System.out.print("Enter your birthdate: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your password: ");
        String userPassword = scanner.nextLine();

        //execute the  InsertQuery
        insertPlayerData(birthDate, userName, userPassword);

        System.out.println("signed in!!");
    }


    // This inserts the players info to the database
    public void insertPlayerData(String birthDate, String userName, String userPassword) throws SQLException {
        String insertDataQuery = "INSERT INTO player (birth_date, username, p_password) VALUES (?, ?, ?)";
        DatabaseManager dbm = new DatabaseManager();
        dbm.getConnection();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = dbm.getConnection();


            PreparedStatement statement = connection.prepareStatement(insertDataQuery);
            statement.setString(1, birthDate);
            statement.setString(2, userName);
            statement.setString(3, userPassword);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: Failed to execute the query.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error: Failed to close the connection.");
                    e.printStackTrace();
                }
            }
        }
    }
}



