package com.leveluptor.drunkard;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    LinkedList<Card> cards = new LinkedList<>();

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
