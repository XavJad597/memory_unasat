package com.unasat.repository.entity.person;

import com.unasat.config.DatabaseManager;

import java.util.Scanner;

public class SignUp {
    private DatabaseManager databaseManager ;
    public SignUp(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
    public void signUp(String userName,String userPassword) {
        // player info
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println(" Sign up");


        System.out.print("Enter your birthdate:   ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter your username:   ");
        userName = scanner.nextLine();
        System.out.print("Enter your password:   ");
        userPassword = scanner.nextLine();


        String url = "jdbc:mysql://localhost:3306/memoryg";
        String username = "root";
        String password = "root";


        //making the query for the name collumn with a parameterized query
        DatabaseManager manager = new DatabaseManager(url, username, password);
        manager.insertPlayerData(birthDate, userName, userPassword);

        System.out.println("signed in!!");
    }
}

                // log in functionatility
           /* case 2:


                LoginManager loginFunction = new LoginManager(loginManager);
                boolean loginSuccess = loginFunction.login(userName, userPassword);

                System.out.println("Log in");

                System.out.print("Enter your username: ");
                userName = scanner.nextLine();
                System.out.print("Enter your password: ");
                userPassword = scanner.nextLine();



                if (loginSuccess) {
                    System.out.println("Logged in successfully!");
                    boolean regLogBool = true;

                    while (regLogBool) {
                        System.out.println("Menu:");
                        System.out.println("1. Update profile");
                        System.out.println("2. Log out");
                        System.out.print("Enter your choice: ");
                        int menuChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character after reading the integer

                        switch (menuChoice) {
                            case 1:// Update profile process
                                System.out.println("Update profile?");
                                System.out.print("Enter your new username:  ");
                                String newUsername = scanner.nextLine();
                                System.out.print("Enter your new password: ");
                                String newPassword = scanner.nextLine();

                                UpdateManager updateManager = new UpdateManager(manageUpdate.);
                                boolean succesUpdate = updateManager.updateProfile(newUsername, newPassword);

                                if (succesUpdate) {
                                    System.out.println("profile updated");
                                } else {
                                    System.out.println("try again");
                                }
                            case 2:
                                System.out.println("logged out");
                            default:
                                System.out.println("Please choose another option.");
                        }
                    }


                }


                // Continue with the rest of your program logic for a successful login
        }
    }
       }


}*/