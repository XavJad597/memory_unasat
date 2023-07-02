package com.unasat.service.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Deck {

    protected ArrayList<Character> cardArray;
    protected ArrayList<Boolean> flippedCards;
    protected ArrayList<Character> shuffledCards;

    public Deck(Character[] cardValues) {
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
        return cardArray.size();
    }

    public boolean isCardFlipped(int cardNumber) {
        return flippedCards.get(cardNumber - 1);
    }

    public void flipCard(int cardNumber) {
        flippedCards.set(cardNumber - 1, true);
    }

    public ArrayList<Character> getShuffledCards() {
        return shuffledCards;
    }
}


class FirstDeck extends Deck {

    public FirstDeck() {
        super(new Character[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F'});
    }

}

class SecondDeck extends Deck {

    public SecondDeck() {
        super(new Character[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E',
                           'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J'});
    }

}

class ThirdDeck extends Deck {

    public ThirdDeck() {
        super(new Character[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E',
                           'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J',
                           'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O'});
    }

}
