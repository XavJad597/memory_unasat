package com.unasat.service.operations;

public class Card {

    //Variables
    private String value;
    private boolean flipped;
    private boolean matched;

    public Card(String value) {
        // Set the card's value based on the provided parameter
        this.value = value;

        // Set the initial state of the card: not flipped and not matched
        this.flipped = false;
        this.matched = false;
    }

    //Value Methods
    public String getValue() {
        return value;
    }

    //Flipped Methods
    public boolean isFlipped() {
        return flipped;
    }

    // Flips the card only if it's not already matched
    public void flip() {
        if (!matched) {
            flipped = !flipped;
        }
    }

    //Match Methods

    // Returns whether the card is matched (true) or not (false)
    public boolean isMatched() {
        return matched;
    }

    // Sets the matched status of the card
    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    // Returns the string representation of the card (its value)
    @Override
    public String toString() {
        return value;
    }
}

