package com.unasat.config;

import com.unasat.config.dbconnector.DatabaseManager;

import java.sql.*;

import static com.unasat.config.LoginManager.player1;

public class Scores {

    private final DatabaseManager databaseManager;
    String userName1 = player1.getUserName();


    //vars
//    int playerID = getPlayerId(userName);


    public Scores() {
        databaseManager = new DatabaseManager("jdbc:mysql://localhost:3306/memoryg", "root", "dKwRaUyYnDeEN0025");
    }

    public void sendScoreToDatabase(int totalGamePoints, String userName1) throws SQLException {
        int playerId = getPlayerId(userName1); // Retrieve the player ID based on the username

        String insertScoreQuery = "INSERT INTO game (score, player_id) VALUES (?, ?)";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertScoreQuery)) {

            insertStatement.setInt(1, totalGamePoints);
            insertStatement.setInt(2, playerId);



            int rowsInserted = insertStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("New score inserted successfully!");
            } else {
                System.out.println("Failed to insert score.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getScoreboard() throws SQLException {

        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

        Connection conn = databaseManager.getConnection();
        ResultSet rs;

        try {

//  playerId is the player's primary key value for whom you want to retrieve the score
            String selectQuery = "SELECT p.username, g.score" +
                    " FROM game g " +
                    "JOIN player as p ON g.player_id = p.player_id " +
                    "ORDER BY g.score DESC " +
                    "LIMIT 10";

            PreparedStatement statement = conn.prepareStatement(selectQuery);

            rs = statement.executeQuery(selectQuery);

           // prints the leaderboard
            System.out.println("Player   |    Score");
            System.out.println("--------------------");

            while (rs.next()) {
                String username = rs.getString("username");
                int score = rs.getInt("score");

                System.out.println(username + "     |     " + score);
            }

            System.out.println("\n\n");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getPlayerId(String name) throws SQLException {
        String getPlayerIdQuery = "{CALL getPlayerId(?, ?)}";
        int playerId;

        try (Connection conn = databaseManager.getConnection();
             CallableStatement callableStatement = conn.prepareCall(getPlayerIdQuery)) {


            callableStatement.setString(1, name);
            callableStatement.registerOutParameter(2, Types.INTEGER);

            callableStatement.execute();

            playerId = callableStatement.getInt(2);
        }

        return playerId;
    }
}




