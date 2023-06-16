package com.unasat.service.operations;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    //Variables
    protected ArrayList<Card> cardArray;

    //Constructors
    public Deck(String[] cardValues) {

        // Create a new ArrayList to store the cards
        cardArray = new ArrayList<>();

        // Creates new Card Object for each String value inserted into the for-loop
        for (String value : cardValues) {
            cardArray.add(new Card(value));
        }
    }
    public Deck() {
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
