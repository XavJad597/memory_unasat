package com.unasat.repository.entity.person;
import com.unasat.config.DatabaseManager;
import java.util.Scanner;

public class Menu {

    protected DatabaseManager databaseManager;
    protected LoginManager loginfuction;
    protected UpdateManager updatefuction;
    private  SignUp signUp;

    public void displayMenu() {

        public  Menu  (DatabaseManager databaseManager) {
            this.DatabaseManager = databaseManager;
            this.LoginFunction = new LoginManager(databaseManager);
            this.UpdateManager = new UpdateManager(databaseManager);
            this.signUp = new SignUp(databaseManager)
        }

        Scanner scanner = new Scanner(System.in);


            //** object references
            LoginManager login = new LoginManager();
            SignUp sign = new SignUp();
            UpdateManager update = new UpdateManager();


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
                        login.login(username, password);
                        break;
                    case 2:

                        sign.signUp(username, password);
                        break;
                    case 3:
                        update.updateProfile(username, password);
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