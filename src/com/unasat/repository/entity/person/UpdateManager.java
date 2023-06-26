
package com.unasat.repository.entity.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.unasat.config.DatabaseManager;

public class UpdateManager {
    DatabaseManager manageUpdate;

    public UpdateManager(DatabaseManager manageUpdate) {
        this.manageUpdate = manageUpdate;
    }


    public boolean updateProfile(String newUsername, String newPassword)throws SQLException {
        String updateQuery = "UPDATE player SET  p_password = ? WHERE username = ?";
        Connection connection = profileUpdate.getConnection();

        try {
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, newPassword);
            updateStatement.setString(2, newUsername);

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Required class not found.");
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
}

