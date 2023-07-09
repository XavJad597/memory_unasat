package com.unasat.service.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Deck {

    protected ArrayList<Character> cardArray;
    protected ArrayList<Boolean> flippedCards;
    protected ArrayList<Character> shuffledCards;

    public Deck(Character[] cardValues) {
        // Constructor to initialize the deck with card values
        cardArray = new ArrayList<>(Arrays.asList(cardValues));
        flippedCards = new ArrayList<>();
        shuffledCards = new ArrayList<>();

        for (int i = 0; i < cardArray.size(); i++) {
            flippedCards.add(false);
        }

        // Shuffle the cardArray and assign the shuffled elements to shuffledCards
        Collections.shuffle(cardArray);
        shuffledCards.addAll(cardArray);
    }

    public int getTotalCards() {
        // Returns the total number of cards in the deck
        return cardArray.size();
    }

    public boolean isCardFlipped(int cardNumber) {
        // Returns true if the card at the specified cardNumber is flipped, false otherwise
        return flippedCards.get(cardNumber - 1);
    }

    public void flipCard(int cardNumber) {
        // Flips the card at the specified cardNumber by updating the flippedCards list
        flippedCards.set(cardNumber - 1, true);
    }

    public ArrayList<Character> getShuffledCards() {
        // Returns the shuffled cards in the deck
        return shuffledCards;
    }
}


class FirstDeck extends Deck {

    public FirstDeck() {
        // Constructs the first deck with specific card values
        super(new Character[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F'});
    }

}

class SecondDeck extends Deck {

    public SecondDeck() {
        // Constructs the second deck with specific card values
        super(new Character[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E',
                'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J'});
    }

}

class ThirdDeck extends Deck {

    public ThirdDeck() {
        // Constructs the third deck with specific card values
        super(new Character[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E',
                'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J',
                'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O'});
    }

}
