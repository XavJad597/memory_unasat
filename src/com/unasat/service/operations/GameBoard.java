package com.unasat.service.operations;

import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
    //Objects
    Deck deck = new Deck();

    //Variables
    protected ArrayList<Character> board;
    protected String[][] gameBoard; // The game board represented as a 2D array
    protected ArrayList<Card> cards; // The list of cards


    //Constructor
    public GameBoard(int rows, int columns) {
        board = new ArrayList<>(); // Initialize the board
        gameBoard = new String[rows][columns]; // Create a 2D array for the game board
        cards = deck.cardArray; // Get the list of cards from the deck
    }
    //Methods

    //Prints board
    public void printBoard() {
        for (int j = 0; j < gameBoard.length; j++) {
            for (int i = 0; i < gameBoard.length; i++) {
                System.out.print("| " + i + " "); // Print the number at each position
            }
            System.out.println("|");
        }
    }

    // Replaces a number within the game board with a card that's under it
    public void initializeBoard(int number) {
    }
}

class Easy extends GameBoard {

    //Objects
    Deck easyDeck = new FirstDeck();

    //Constructors
    public Easy() {

        super(3, 4); // Call the parent class constructor to set the dimensions of the game board

        cards = easyDeck.cardArray; // Get the list of cards from the easyDeck
        Collections.shuffle(cards); // Shuffle the cards randomly

        // Set the initial numbers on the game board
        gameBoard[0][0] = " │ 1│ "; // Number 1 in a box
        gameBoard[0][1] = " │ 2│ "; // Number 2 in a box
        gameBoard[0][2] = " │ 3│ "; // Number 3 in a box
        gameBoard[0][3] = " │ 4│ "; // Number 4 in a box
        gameBoard[1][0] = " │ 5│ "; // Number 5 in a box
        gameBoard[1][1] = " │ 6│ "; // Number 6 in a box
        gameBoard[1][2] = " │ 7│ "; // Number 7 in a box
        gameBoard[1][3] = " │ 8│ "; // Number 8 in a box
        gameBoard[2][0] = " │ 9│ "; // Number 9 in a box
        gameBoard[2][1] = " │10│ "; // Number 10 in a box
        gameBoard[2][2] = " │11│ "; // Number 11 in a box
        gameBoard[2][3] = " │12│ "; // Number 12 in a box

    }


    //Methods

    // Print the game board with the updated cards
    @Override
    public void printBoard() {
        for (int j = 0; j < gameBoard.length; j++) {
            for (int i = 0; i < gameBoard[j].length; i++) {
                System.out.print("| " + gameBoard[j][i] + " ");
            }
            System.out.println("|");
        }
    }

    // Replace the number on the game board with the corresponding card value
    public void initializeBoard(int number) {

        switch (number) {
            case 1:
                gameBoard[0][0] = " | " + cards.get(0).getValue() + "| ";
                break;
            case 2:
                gameBoard[0][1] = " | " + cards.get(1).getValue() + "| ";
                break;
            case 3:
                gameBoard[0][2] = " | " + cards.get(2).getValue() + "| ";
                break;
            case 4:
                gameBoard[0][3] = " | " + cards.get(3).getValue() + "| ";
                break;
            case 5:
                gameBoard[1][0] = " | " + cards.get(4).getValue() + "| ";
                break;
            case 6:
                gameBoard[1][1] = " | " + cards.get(5).getValue() + "| ";
                break;
            case 7:
                gameBoard[1][2] = " | " + cards.get(6).getValue() + "| ";
                break;
            case 8:
                gameBoard[1][3] = " | " + cards.get(7).getValue() + "| ";
                break;
            case 9:
                gameBoard[2][0] = " | " + cards.get(8).getValue() + "| ";
                break;
            case 10:
                gameBoard[2][1] = " | " + cards.get(9).getValue() + "| ";
                break;
            case 11:
                gameBoard[2][2] = " | " + cards.get(10).getValue() + "| ";
                break;
            case 12:
                gameBoard[2][3] = " | " + cards.get(11).getValue() + "| ";
                break;
            default:
                System.out.println("Invalid number");
        }
    }
}

class Medium extends GameBoard {

    //Objects
    Deck mediumDeck = new SecondDeck();

    //Constructors
    public Medium() {
        super(4, 5); // Call the parent class constructor to set the dimensions of the game board

        cards = mediumDeck.cardArray; // Get the list of cards from the easyDeck
        Collections.shuffle(cards); // Shuffle the cards randomly

        gameBoard[0][0] = " │ 1│ "; // Number 1 in a box
        gameBoard[0][1] = " │ 2│ "; // Number 2 in a box
        gameBoard[0][2] = " │ 3│ "; // Number 3 in a box
        gameBoard[0][3] = " │ 4│ "; // Number 4 in a box
        gameBoard[0][4] = " │ 5│ "; // Number 5 in a box
        gameBoard[1][0] = " │ 6│ "; // Number 6 in a box
        gameBoard[1][1] = " │ 7│ "; // Number 7 in a box
        gameBoard[1][2] = " │ 8│ "; // Number 8 in a box
        gameBoard[1][3] = " │ 9│ "; // Number 9 in a box
        gameBoard[1][4] = " │10│ "; // Number 10 in a box
        gameBoard[2][0] = " │11│ "; // Number 11 in a box
        gameBoard[2][1] = " │12│ "; // Number 12 in a box
        gameBoard[2][2] = " │13│ "; // Number 13 in a box
        gameBoard[2][3] = " │14│ "; // Number 14 in a box
        gameBoard[2][4] = " │15│ "; // Number 15 in a box
        gameBoard[3][0] = " │16│ "; // Number 16 in a box
        gameBoard[3][1] = " │17│ "; // Number 17 in a box
        gameBoard[3][2] = " │18│ "; // Number 18 in a box
        gameBoard[3][3] = " │19│ "; // Number 19 in a box
        gameBoard[3][4] = " │20│ "; // Number 20 in a box
    }

    //Methods

    // Print the game board with the updated cards
    @Override
    public void printBoard() {
        for (int j = 0; j < gameBoard.length; j++) {
            for (int i = 0; i < gameBoard[j].length; i++) {
                System.out.print("| " + gameBoard[j][i] + " ");
            }
            System.out.println("|");
        }
    }

    // Replace the number on the game board with the corresponding card value
    @Override
    public void initializeBoard(int number) {
        switch (number) {
            case 1:
                gameBoard[0][0] = " | " + cards.get(0).getValue() + "| ";
                break;
            case 2:
                gameBoard[0][1] = " | " + cards.get(1).getValue() + "| ";
                break;
            case 3:
                gameBoard[0][2] = " | " + cards.get(2).getValue() + "| ";
                break;
            case 4:
                gameBoard[0][3] = " | " + cards.get(3).getValue() + "| ";
                break;
            case 5:
                gameBoard[0][4] = " | " + cards.get(4).getValue() + "| ";
                break;
            case 6:
                gameBoard[1][0] = " | " + cards.get(5).getValue() + "| ";
                break;
            case 7:
                gameBoard[1][1] = " | " + cards.get(6).getValue() + "| ";
                break;
            case 8:
                gameBoard[1][2] = " | " + cards.get(7).getValue() + "| ";
                break;
            case 9:
                gameBoard[1][3] = " | " + cards.get(8).getValue() + "| ";
                break;
            case 10:
                gameBoard[1][4] = " | " + cards.get(9).getValue() + "| ";
                break;
            case 11:
                gameBoard[2][0] = " | " + cards.get(10).getValue() + "| ";
                break;
            case 12:
                gameBoard[2][1] = " | " + cards.get(11).getValue() + "| ";
                break;
            case 13:
                gameBoard[2][2] = " | " + cards.get(12).getValue() + "| ";
                break;
            case 14:
                gameBoard[2][3] = " | " + cards.get(13).getValue() + "| ";
                break;
            case 15:
                gameBoard[2][4] = " | " + cards.get(14).getValue() + "| ";
                break;
            case 16:
                gameBoard[3][0] = " | " + cards.get(15).getValue() + "| ";
                break;
            case 17:
                gameBoard[3][1] = " | " + cards.get(16).getValue() + "| ";
                break;
            case 18:
                gameBoard[3][2] = " | " + cards.get(17).getValue() + "| ";
                break;
            case 19:
                gameBoard[3][3] = " | " + cards.get(18).getValue() + "| ";
                break;
            case 20:
                gameBoard[3][4] = " | " + cards.get(19).getValue() + "| ";
                break;
            default:
                System.out.println("Invalid number");
        }
    }
}

class Hard extends GameBoard {

    Deck hardDeck = new ThirdDeck();

    public Hard() {
        super(5, 6); // Call the parent class constructor to set the dimensions of the game board

        cards = hardDeck.cardArray; // Get the list of cards from the easyDeck
        Collections.shuffle(cards); // Shuffle the cards randomly

        // Set the initial numbers on the game board
        gameBoard[0][0] = " │ 1│ "; // Number 1 in a box
        gameBoard[0][1] = " │ 2│ "; // Number 2 in a box
        gameBoard[0][2] = " │ 3│ "; // Number 3 in a box
        gameBoard[0][3] = " │ 4│ "; // Number 4 in a box
        gameBoard[0][4] = " │ 5│ "; // Number 5 in a box
        gameBoard[0][5] = " │ 6│ "; // Number 6 in a box
        gameBoard[1][0] = " │ 7│ "; // Number 7 in a box
        gameBoard[1][1] = " │ 8│ "; // Number 8 in a box
        gameBoard[1][2] = " │ 9│ "; // Number 9 in a box
        gameBoard[1][3] = " │10│ "; // Number 10 in a box
        gameBoard[1][4] = " │11│ "; // Number 11 in a box
        gameBoard[1][5] = " │12│ "; // Number 12 in a box
        gameBoard[2][0] = " │13│ "; // Number 13 in a box
        gameBoard[2][1] = " │14│ "; // Number 14 in a box
        gameBoard[2][2] = " │15│ "; // Number 15 in a box
        gameBoard[2][3] = " │16│ "; // Number 16 in a box
        gameBoard[2][4] = " │17│ "; // Number 17 in a box
        gameBoard[2][5] = " │18│ "; // Number 18 in a box
        gameBoard[3][0] = " │19│ "; // Number 19 in a box
        gameBoard[3][1] = " │20│ "; // Number 20 in a box
        gameBoard[3][2] = " │21│ "; // Number 21 in a box
        gameBoard[3][3] = " │22│ "; // Number 22 in a box
        gameBoard[3][4] = " │23│ "; // Number 23 in a box
        gameBoard[3][5] = " │24│ "; // Number 24 in a box
        gameBoard[4][0] = " │25│ "; // Number 25 in a box
        gameBoard[4][1] = " │26│ "; // Number 26 in a box
        gameBoard[4][2] = " │27│ "; // Number 27 in a box
        gameBoard[4][3] = " │28│ "; // Number 28 in a box
        gameBoard[4][4] = " │29│ "; // Number 29 in a box
        gameBoard[4][5] = " │30│ "; // Number 30 in a box
    }


    //Methods

    // Print the game board with the updated cards
    public void printBoard() {
        for (int j = 0; j < gameBoard.length; j++) {
            for (int i = 0; i < gameBoard[j].length; i++) {
                System.out.print("| " + gameBoard[j][i] + " ");
            }
            System.out.println("|");
        }
    }

    // Replace the number on the game board with the corresponding card value
    @Override
    public void initializeBoard(int number) {
        switch (number) {
            case 1:
                gameBoard[0][0] = " | " + cards.get(0).getValue() + "| ";
                break;
            case 2:
                gameBoard[0][1] = " | " + cards.get(1).getValue() + "| ";
                break;
            case 3:
                gameBoard[0][2] = " | " + cards.get(2).getValue() + "| ";
                break;
            case 4:
                gameBoard[0][3] = " | " + cards.get(3).getValue() + "| ";
                break;
            case 5:
                gameBoard[0][4] = " | " + cards.get(4).getValue() + "| ";
                break;
            case 6:
                gameBoard[0][5] = " | " + cards.get(5).getValue() + "| ";
                break;
            case 7:
                gameBoard[1][0] = " | " + cards.get(6).getValue() + "| ";
                break;
            case 8:
                gameBoard[1][1] = " | " + cards.get(7).getValue() + "| ";
                break;
            case 9:
                gameBoard[1][2] = " | " + cards.get(8).getValue() + "| ";
                break;
            case 10:
                gameBoard[1][3] = " | " + cards.get(9).getValue() + "| ";
                break;
            case 11:
                gameBoard[1][4] = " | " + cards.get(10).getValue() + "| ";
                break;
            case 12:
                gameBoard[1][5] = " | " + cards.get(11).getValue() + "| ";
                break;
            case 13:
                gameBoard[2][0] = " | " + cards.get(12).getValue() + "| ";
                break;
            case 14:
                gameBoard[2][1] = " | " + cards.get(13).getValue() + "| ";
                break;
            case 15:
                gameBoard[2][2] = " | " + cards.get(14).getValue() + "| ";
                break;
            case 16:
                gameBoard[2][3] = " | " + cards.get(15).getValue() + "| ";
                break;
            case 17:
                gameBoard[2][4] = " | " + cards.get(16).getValue() + "| ";
                break;
            case 18:
                gameBoard[2][5] = " | " + cards.get(17).getValue() + "| ";
                break;
            case 19:
                gameBoard[3][0] = " | " + cards.get(18).getValue() + "| ";
                break;
            case 20:
                gameBoard[3][1] = " | " + cards.get(19).getValue() + "| ";
                break;
            case 21:
                gameBoard[3][2] = " | " + cards.get(20).getValue() + "| ";
                break;
            case 22:
                gameBoard[3][3] = " | " + cards.get(21).getValue() + "| ";
                break;
            case 23:
                gameBoard[3][4] = " | " + cards.get(22).getValue() + "| ";
                break;
            case 24:
                gameBoard[3][5] = " | " + cards.get(23).getValue() + "| ";
                break;
            case 25:
                gameBoard[4][0] = " | " + cards.get(24).getValue() + "| ";
                break;
            case 26:
                gameBoard[4][1] = " | " + cards.get(25).getValue() + "| ";
                break;
            case 27:
                gameBoard[4][2] = " | " + cards.get(26).getValue() + "| ";
                break;
            case 28:
                gameBoard[4][3] = " | " + cards.get(27).getValue() + "| ";
                break;
            case 29:
                gameBoard[4][4] = " | " + cards.get(28).getValue() + "| ";
                break;
            case 30:
                gameBoard[4][5] = " | " + cards.get(29).getValue() + "| ";
                break;
            default:
                System.out.println("Invalid number");
        }
    }
}
