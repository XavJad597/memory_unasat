package com.unasat.service.connection;

import java.sql.*;
import java.util.ArrayList;
import com.unasat.config.DatabaseManager;
import com.unasat.service.operations.GameController;

public class Scores {
    private GameController gameController;
    private DatabaseManager databaseManager;


    public Scores() {
        gameController = new GameController();
        databaseManager = new DatabaseManager();
    }

    public void   sendScore(int playerId) {
        int score = gameController.calculatePoints();

        String insertScoreQuery = "INSERT INTO game (player_id, score) VALUES (?, ?)";

        try (Connection connection = databaseManager.getConnection("jdbc:mysql://localhost:3306/memoryg", "root", "root");
             PreparedStatement statement = connection.prepareStatement(insertScoreQuery)) {

            // Set the parameter values
            statement.setInt(1, playerId);
            statement.setInt(2, score);

            // Execute the insert query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Score inserted successfully!");
            } else {
                System.out.println("Failed to insert score.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getHighScores() {
        ArrayList<String> highScores = new ArrayList<>();

        String query ="SELECT g.score, p.username"+
        "FROM game g"+
       "jOIN player p ON g.player_id = p.player_id "+
                "ORDER BY g.score DESC " +
                "LIMIT 10"; // Change the limit as per your requirement

        try (Connection connection = databaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int score = resultSet.getInt("score");
                String username = resultSet.getString("username");
                String scoreHigh = username + ": " + score;
                highScores.add(scoreHigh);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highScores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("High Scores:\n");
        ArrayList<String> highScores = getHighScores();

        for (String scoreEntry : highScores) {
            sb.append(scoreEntry);
            sb.append("\n");
        }

        return sb.toString();
    }
}