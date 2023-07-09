package com.unasat.config;

import com.unasat.config.dbconnector.DatabaseManager;

import java.util.Scanner;

public class SignUp {
    Connection connection;

    public SignUp() {
    }

    //Signup method
    public void signUp() throws SQLException {
        // player info
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Sign up");

       // enter your info
        System.out.print("Enter your birthdate: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your password: ");
        String userPassword = scanner.nextLine();

        //execute the  InsertQuery
        insertPlayerData(birthDate, userName, userPassword);

        System.out.println("signed in!!");
    }
}

