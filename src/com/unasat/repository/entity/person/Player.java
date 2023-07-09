package com.unasat.repository.entity.person;


import com.unasat.config.DatabaseManager;
import com.unasat.service.connection.Scores;

public class Player {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/memoryg";
        String username = "root";
        String password = "root";

        DatabaseManager databaseManager = new DatabaseManager(url, username, password);
        Scores highscore = new Scores();
        Menu play = new Menu(databaseManager);
        play.displayMenu();
    }
}
