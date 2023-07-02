package com.unasat.repository.entity.person;

import com.unasat.config.DatabaseManager;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    protected DatabaseManager databaseManager;
    protected LoginManager LoginManager;
    protected UpdateManager UpdateManager;
    protected SignUp signUp;

    public Menu (DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.LoginManager = new LoginManager(databaseManager);
        this.UpdateManager = new UpdateManager(databaseManager);
        this.signUp = new SignUp(databaseManager);
    }
    public void displayMenu() {
        //** object references
        LoginManager login = new LoginManager(databaseManager);
        SignUp sign = new SignUp(databaseManager);
        UpdateManager update = new UpdateManager(databaseManager);

        Scanner scanner = new Scanner(System.in);

         String userName="";
        String  userPassword="";
        String newUsername="";
        String newPassword="";

           while (true) {
            System.out.println("Menu:");
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.println("3. Update profile");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();



            switch (choice) {
                case 1:
                    try {
                        boolean loggedIn = login.login(userName, userPassword);
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
                case 3: try {

                    System.out.print("Enter your new username: ");
                    newUsername = scanner.nextLine();
                    System.out.print("Enter your new password: ");
                    newPassword = scanner.nextLine();


                    boolean profileUpdated = update.updateProfile(newUsername, newPassword);
                    if (profileUpdated) {
                        System.out.println("Profile updated successfully!");
                        // Continue with any additional logic
                    } else {
                        System.out.println("Failed to update profile.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error occurred during profile update: " + e.getMessage());
                }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
