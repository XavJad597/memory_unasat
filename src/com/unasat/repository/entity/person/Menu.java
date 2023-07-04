package com.unasat.repository.entity.person;

import com.unasat.config.DatabaseManager;
import com.unasat.service.connection.Scores;


import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    protected DatabaseManager databaseManager;
    protected LoginManager LoginManager;

    protected SignUp signUp;

    public Menu (DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.LoginManager = new LoginManager(databaseManager);
        this.signUp = new SignUp(databaseManager);
    }
    public void displayMenu() {
        //** object references
        LoginManager login = new LoginManager(databaseManager);
        SignUp sign = new SignUp(databaseManager);
       Combinescore game = new Combinescore();
        Scores highscore  = new Scores();

        Scanner scanner = new Scanner(System.in);

         String userName="";
        String  userPassword="";

           while (true) {
            System.out.println("Menu:");
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.println("3. play game");
            System.out.println("4. highscore");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();



            switch (choice) {
                case 1:
                    try {
                        boolean loggedIn = login.login();
                        if (loggedIn) {
                            System.out.println("Login successful!");
                            // Continue with logged-in user flow or any other desired logic
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error occurred during login: " + e.getMessage());
                    }
                    break;
                case 2:
                    sign.signUp(userName, userPassword);
                    break;
                case 3:
                    game.gamePlay();
                    break;
                case 4:
                    highscore.getHighScores();

                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
