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

    enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JARAXXUS, QUEEN, KING
    }

    @Override
    public String toString() {
        return rank.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
    }
}
