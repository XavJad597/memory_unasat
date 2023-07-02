
package com.unasat.repository.entity.person;

import com.unasat.config.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateManager {
    DatabaseManager manageUpdate;

    public UpdateManager(DatabaseManager manageUpdate) {
        this.manageUpdate = manageUpdate;
    }


    public boolean updateProfile(String newUsername, String newPassword)throws SQLException {
        String updateQuery = "UPDATE player SET  p_password = ? WHERE username = ?";
        Connection connection = manageUpdate.getConnection();

        try {
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, newPassword);
            updateStatement.setString(2, newUsername);

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error occurred during profile update: " + e.getMessage());
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

  public   boolean profileExists(String userName,String userPassword) throws SQLException {
        String selectQuery = "SELECT * FROM player WHERE username = ? AND p_password=?";
        Connection connection = manageUpdate.getConnection();

        try {
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, userName);
            selectStatement.setString(2,userPassword);
            ResultSet resultSet = selectStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error occurred during profile update: " + e.getMessage());
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

