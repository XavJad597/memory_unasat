
package com.unasat.repository.entity.person;

import com.unasat.config.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateManager {
    DatabaseManager manageUpdate;

    public UpdateManager(DatabaseManager manageUpdate) {
        this.manageUpdate = manageUpdate;
    }


    public boolean updateProfile(String newUsername, String newPassword)throws SQLException {
         Scanner scanner=new Scanner(System.in);

        System.out.print("Enter your new username: ");
        newUsername = scanner.nextLine();
        System.out.print("Enter your new password: ");
        newPassword = scanner.nextLine();

        if(!profileExists(newUsername)) {
            System.out.println("Profile does not exist");
       return false;
}
        String updateQuery = "UPDATE player SET  p_password = ? WHERE username = ?";
        Connection connection = manageUpdate.getConnection();

        try {
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, newPassword);
            updateStatement.setString(2, newUsername);

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database.");
            e.printStackTrace();
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

        return false;
    }


  public   boolean profileExists(String username) throws SQLException {
        String selectQuery = "SELECT * FROM player WHERE username = ?";
        Connection connection = manageUpdate.getConnection();

        try {
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, username);

            ResultSet resultSet = selectStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error: Failed to execute the select query.");
            e.printStackTrace();
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

        return false;
    } }

