package com.unasat.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
        private String url;
        private String username;
        private String password;

        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, password);
        }

        public DatabaseManager(String url, String username, String password) {
            //log in to your database
            this.url = url;
            this.username = username;
            this.password = password;
        }

        public void insertPlayerData(String birthDate, String userName, String userPassword) {
            String insertDataQuery = "INSERT INTO player (birth_date, username, p_password) VALUES (?, ?, ?)";
            Connection connection = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);

                PreparedStatement statement = connection.prepareStatement(insertDataQuery);
                statement.setString(1, birthDate);
                statement.setString(2, userName);
                statement.setString(3, userPassword);
                statement.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error: Failed to execute the query.");
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
        }
    }


