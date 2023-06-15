package com.unasat.service.operations;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    protected ArrayList<Card> cardArray;

    public Deck(String[] cardValues) {
        cardArray = new ArrayList<>();
        for (String value : cardValues) {
            cardArray.add(new Card(value));
        }
    }


    public void displayCards() {
        System.out.println(cardArray);
    }

    public void shuffleDeck() {
        Collections.shuffle(cardArray);
    }

}

class FirstDeck extends Deck {

    public FirstDeck() {
        super(new String[]{"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F"});
    }

}

class SecondDeck extends Deck {

    public SecondDeck() {
        super(new String[]{"A", "A", "B", "B", "C", "C", "D", "D", "E", "E",
                           "F", "F", "G", "G", "H", "H", "I", "I", "J", "J"});
    }

}

class ThirdDeck extends Deck {

    public ThirdDeck() {
        super(new String[]{"A", "A", "B", "B", "C", "C", "D", "D", "E", "E",
                           "F", "F", "G", "G", "H", "H", "I", "I", "J", "J",
                           "K", "K", "L", "L", "M", "M", "N", "N", "O", "O"});
    }

}
