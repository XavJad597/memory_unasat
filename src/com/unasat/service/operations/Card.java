package com.unasat.service.operations;

public class Card {
    private String value;
    private boolean flipped;

    public Card(String value) {
        this.value = value;
        this.flipped = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void flip() {
        flipped = !flipped;
    }

    @Override
    public String toString() {
        return value;
    }
}

