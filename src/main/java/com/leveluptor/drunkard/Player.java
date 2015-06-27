package com.leveluptor.drunkard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Player {
    String name;
    Deque<Card> cards = new LinkedList<>();

    Deque<Card> staging = new LinkedList<>();

    public Player(String name) {
        this.name = name;
    }

    public void revealTopCard() {
        if (cards.isEmpty()) {
            System.out.println(name + " has " + cards.size() + " cards and lost");
            System.exit(0);
        } else {
            staging.addFirst(cards.pop());
        }
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
