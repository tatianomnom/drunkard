package com.leveluptor.drunkard;

import java.util.ArrayDeque;
import java.util.Deque;

public class Player {
    String name;
    Deque<Card> cards = new ArrayDeque<>();

    Deque<Card> staging = new ArrayDeque<>();

    public Player(String name) {
        this.name = name;
    }

    public void revealTopCard() {
        staging.add(cards.pop());
    }

    public Deque<Card> getStaging() {
        return staging;
    }

    public Deque<Card> giveStagingCards() {
        Deque<Card> temporaryCards = new ArrayDeque<>();
        while (!staging.isEmpty()){
            temporaryCards.add(staging.pop());
        }
        return temporaryCards;
    }
}
