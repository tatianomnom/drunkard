package com.leveluptor.drunkard;

public class Card {

    private final Suit suit;

    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    // I forgot how guy between Ten and Queen is called in English, but Lord Jaraxxus turned out to be a good fit.
    enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JARAXXUS, QUEEN, KING
    }

    @Override
    public String toString() {
        return rank.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
    }
}
