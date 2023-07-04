package com.unasat.service.operations;

import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class GameController {
    private Level currentLevel;
    private int levelNumber;
    private Deck currentDeck;
    private GameBoard gameBoard;
    private int totalPoints; // Variable to store the total points

    public GameController() {
        this.currentLevel = null;
        this.currentDeck = null;
        this.gameBoard = null;
        this.totalPoints = 0;
    }

    public void playGame() {
        levelNumber = 3; // Set the initial level number
        initializeGame(levelNumber); // Initialize the current level

        while (currentLevel != null && !currentLevel.isFinished() && !currentLevel.isGameOverEarly()) {
            printLevel(); // Print the current level

            // Play the current level
            playLevel(currentDeck);
        }

        if (currentLevel != null && currentLevel.isFinished()) {
            System.out.println("Congratulations, you have completed level " + levelNumber);
            levelNumber++;
            advanceToNextLevel(); // Advance to the next level
            initializeGame(levelNumber); // Initialize the new level
        }

        if (currentLevel != null && currentLevel.isGameOverEarly()) {
            System.out.println("Game over early");
        }
    }



    public void playLevel(Deck currentDeck) {
        int cardNumber1, cardNumber2;
        boolean cardsMatched;


        while (!currentLevel.isFinished() && !currentLevel.isGameOverEarly()) {
            printLevel(); // Print the current level

            do {
                cardNumber1 = getPlayerInput("Select the first card: ");
                cardNumber2 = getPlayerInput("Select the second card: ");

                cardsMatched = compareCards(cardNumber1, cardNumber2);

                if (allCardsMatched()) {
                    currentLevel.setFinished(true); // Set the level as finished
                }

            } while (!cardsMatched && !currentLevel.isFinished() && !currentLevel.isGameOverEarly());

            // Check if the level is finished
            if (currentLevel.isFinished()) {
                totalPoints += calculatePoints(); // Add the points to the totalPoints variable
                System.out.println("Level " + levelNumber + " completed!");
                System.out.println("Total Points: " + totalPoints); // Print the updated total points
            }

            if (currentLevel.isGameOverEarly()) {
                totalPoints += calculatePoints(); // Add the points to the totalPoints variable
                System.out.println("Game over! You've made too many mistakes...");
                System.out.println("Total Points: " + totalPoints); // Print the updated total points
                break;
            }
        }
    }

    private void initializeGame(int levelNumber) {

        // Create the corresponding level based on the level number
        switch (levelNumber) {
            case 1:
                currentLevel = new EasyLevel();
                break;
            case 2:
                currentLevel = new MediumLevel();
                break;
            case 3:
                currentLevel = new HardLevel();
                break;
        }

        // Initialize any other necessary variables or game components
        gameBoard = getCorrespondingGameBoard(currentLevel); // Initialize the game board
        currentDeck = getCorrespondingDeck(currentLevel); // Set the initial deck based on the level

        playLevel(currentDeck);
    }


    //Level related methods
    private Deck getCorrespondingDeck(Level level) {
        if (level instanceof EasyLevel) {
            return new FirstDeck();
        } else if (level instanceof MediumLevel) {
            return new SecondDeck();
        } else if (level instanceof HardLevel) {
            return new ThirdDeck();
        } else {
            // Default case, return null or throw an exception depending on your requirements
            return null;
        }
    }

    private GameBoard getCorrespondingGameBoard(Level level) {
        if (level instanceof EasyLevel) {
            return new Easy();
        } else if (level instanceof MediumLevel) {
            return new Medium();
        } else if (level instanceof HardLevel) {
            return new Hard();
        } else {
            // Default case, return null or throw an exception depending on your requirements
            return null;
        }
    }


    public void printLevel() {
            System.out.println("Level: " + levelNumber);
            System.out.println("Number of mistakes made: " + currentLevel.getMistakes());
            System.out.println("Points: " + currentLevel.getPoints());
            System.out.println("Game Board:");
            gameBoard.printBoard();
        }


    public void advanceToNextLevel() {

        if (currentLevel instanceof EasyLevel) {
            currentLevel = new MediumLevel();
            currentDeck = new SecondDeck();
        } else if (currentLevel instanceof MediumLevel) {
            currentLevel = new HardLevel();
            currentDeck = new ThirdDeck();
        } else if (currentLevel instanceof HardLevel) {
            // If the current level is already the hardest level, you can choose to handle it in a specific way
            System.out.println("You have completed the highest level. Game completed!");
            currentLevel = null; // Set currentLevel to null to indicate game completion
            currentDeck = null; // Set currentDeck to null
            return; // Return here to prevent further execution
        }

    }


    public boolean compareCards(int cardNumber1, int cardNumber2) {
        Character card1 = getCardAt(cardNumber1);
        Character card2 = getCardAt(cardNumber2);

        if (cardNumber1 <= 0 || cardNumber2 <= 0) {
            return false;
        }

        // Check if the selected cards are already flipped or matched
        if (currentDeck.isCardFlipped(cardNumber1) || currentDeck.isCardFlipped(cardNumber2)) {
            System.out.println("Card is already flipped. Choose another card.");
            return false;
        }

        if (cardNumber1 == cardNumber2) {
            System.out.println("You can't select the same card twice");
            System.out.println("Choose different cards");
            return false;
        }

        gameBoard.initializeBoard(cardNumber1);
        gameBoard.initializeBoard(cardNumber2);
        System.out.println(card1);
        System.out.println(card2);

        if (card1.equals(card2)) {
            System.out.println("Cards match!");
            flipCard(cardNumber1);
            flipCard(cardNumber2);
            currentLevel.cardMatched();
            printLevel();
            return true;
        } else {
            System.out.println("Cards do not match!");
            currentLevel.incrementMistakes();
            printLevel();
            gameBoard.retrieveInitialNumber(cardNumber1);
            gameBoard.retrieveInitialNumber(cardNumber2);
            return false;
        }
    }


    private int getPlayerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);

        try {
            int input = scanner.nextInt();
            if (input > 0 && input <= currentDeck.getTotalCards()) {
                if (!currentDeck.isCardFlipped(input)) {
                    return input;
                } else {
                    System.out.println("Card is already flipped. Choose another card.");
                    return -1; // Return a negative value to indicate an invalid input
                }
            } else {
                System.out.println("Invalid card number! Please try again.");
                return -1; // Return a negative value to indicate an invalid input
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid card number.");
            return -1; // Return a negative value to indicate an invalid input
        }
    }



    public Character getCardAt(int cardNumber) {
        if (cardNumber >= 1 && cardNumber <= currentDeck.getTotalCards()) {
            return gameBoard.getCard(cardNumber);
        } else {
            System.out.println("Invalid card number!");
            return null;
        }
    }

    public void flipCard(int cardNumber) {
        gameBoard.initializeBoard(cardNumber);
        currentDeck.flipCard(cardNumber); // Flip the card in the deck
//        gameBoard.printBoard();
    }

   public int calculatePoints() {
        int remainingMistakes = 10 - currentLevel.getMistakes();
        return (currentLevel.getPoints()) + ((remainingMistakes > 0) ? remainingMistakes * 3 : 0);
    }

    public boolean allCardsMatched() {
        for (Boolean card : currentDeck.flippedCards) {
            if (!card) {
                return false; // If there is any non-matched card on the board, return false
            }
        }
        return true; // All cards have been matched
    }



}
