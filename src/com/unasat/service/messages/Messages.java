package com.unasat.service.messages;

public class Messages {

    //Menu messages
    public void signInUpMsg() {
        System.out.println("Please log in or sign up\n");
        System.out.println("Press 1 to log in");
        System.out.println("Press 2 to sign up");
        System.out.println("Press 3 to change your password");
        System.out.println("Press 4 to exit the game");
    }

    public void mainMenuMsg() {
        System.out.println("What would you like to do?\n");
        System.out.println("Press 1 to start playing");
        System.out.println("Press 2 to check out player high scores");
        System.out.println("Press 3 to log out");
        System.out.println("Press 4 to exit the game");
    }

    public void endMenu() {
        System.out.println("What would you like to do?\n");
        System.out.println("Press 1 to replay the game");
        System.out.println("Press 2 to exit the game");
    }



    //Interactive messages
    public void welcomeMsg(String name) {
        System.out.println("Welcome, " + name);
    }

    public void goodByeMsg(String name) {
        System.out.println("We hope you had a nice time playing");
        System.out.println("We hope to see you next time, " + name);
    }



    //Personal Information Messages
    public void enterUName() {
        System.out.println("Please enter your username");
    }

    public void enterPassword() {
        System.out.println("Please enter your password");
    }

    public void accountNumber() {
        System.out.println("Please enter your account number if you want to change your personal Information");
    }



    //Game messages
    public void gameStart() {
        System.out.println("The game has started");
    }

    public void pointGained(int score){
        System.out.println("You've gained 2 point");
        System.out.println("Your total score = " + score);
    }

    public void pointLost(int score){
        System.out.println("You've lost a point");
        System.out.println("Your total score = " + score);
    }

    public void earlyGameOver() {
        System.out.println("  You've made more than 3 mistakes");
        System.out.println("Sadly, we have to end the game early");
        System.out.println("              Game over              ");
    }

    public void earlyGameOver(String name, int score) {
        System.out.println("Congratulations, " + name);
        System.out.println("Your total score is " + score);
        System.out.println("              Game over              ");
    }

    //Error Messages
    public void wrongChars() {
        System.out.println("You've entered the wrong character");
        System.out.println("Please try again");
    }

    public void wrongNamePassword() {
        System.out.println("Player doesn't exist");
        System.out.println("Please make sure you're using the right information");
    }

    public void notAllowedChar() {
        System.out.println("You're not allowed to use those characters(!, @, $, %, etc.)");
        System.out.println("Please enter only characters that are allowed");
    }

}
