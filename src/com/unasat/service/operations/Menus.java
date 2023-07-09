package com.unasat.service.operations;

import com.unasat.config.LoginManager;
import com.unasat.config.Scores;
import com.unasat.config.SignUp;
import com.unasat.config.dbconnector.DatabaseManager;

import java.sql.SQLException;
import java.util.Scanner;


public class Menus {

    Scanner scanner = new Scanner(System.in);
    LoginManager login;
    SignUp signUp;
    DatabaseManager databaseManager;
    GameController game = new GameController();
    Scores scores = new Scores();
    public Menus(DatabaseManager databaseManager) throws SQLException {
        this.databaseManager = databaseManager;
        this.login = new LoginManager(databaseManager);
        this.signUp = new SignUp();
    }
    public Menus() throws SQLException {
    }

    public void fullGame() throws SQLException {
        userMenu();
    }


     // Start menuw when u start up the game
    public void userMenu() throws SQLException {



        while(true){


            String userMenu = """
                    Menu:
                    1. log in
                    2. Sign up
                    3. Exit Game
                    """;

            System.out.println(userMenu);

            System.out.println("Pick an option:");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    try {
                        boolean loggedIn = login.login();
                        if (loggedIn) {
                            System.out.println("Login successful!");
                            // Continue with logged-in user flow or any other desired logic

                            mainMenu();

                        } else {
                            System.out.println("Invalid username or password.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error occurred during login: " + e.getMessage());
                    }
                    break;
                case 2:
                    signUp.signUp();
                    break;
                case 3:
                    System.out.println("Exiting game.......");
                    return;
                default:
                    System.out.println("You've chosen an option that isn't available");
                    System.out.println("Please pick another option");
                    break;
            }
        }

    }

    // after singing up and logging in u get to this menu
    public void mainMenu() throws SQLException {


        while (true){

            String userMenu = """
                    Menu:
                    1. Play Game
                    2. Check The LeaderBoard
                    3. Exit Game
                                    
                    """;

            System.out.println(userMenu);

            System.out.println("Pick an option:");


            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                        game.playGame();
                    break;
                case 2:
                    scores.getScoreboard();
                    break;
                case 3:
                    System.out.println("Exiting game.......");
                    return;
                default:
                    System.out.println("You've chosen an option that isn't available");
                    System.out.println("Please pick another option");
                    break;
            }
        }

    }


}
