package com.tatianomnom.drunkard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Deck {

    Deque<Card> cards = new LinkedList<>();

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        List<Card> tmpList = new ArrayList<>(cards);
        Collections.shuffle(tmpList);
        cards = new LinkedList<>(tmpList);

    }
}
