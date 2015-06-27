package com.leveluptor.drunkard;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Deck deck = new Deck();

    List<Player> allPlayers = new ArrayList<>();

    public static Game withPlayers(int numberOfPlayers) {

        Game game = new Game();
        for (int i = 0; i < numberOfPlayers; i++) {
            List<Player> gamePlayers = game.allPlayers;
            gamePlayers.add(new Player("Player " + i));
        }

        return game;
    }

    public void dealCards() {
        deck.shuffle();
        while (deck.cards.size() >= allPlayers.size()) {
            for (Player player : allPlayers) {
                player.cards.add(deck.cards.pop());
            }
        }
    }

    public void playOneRound() {
        System.out.println("---One real round started");
        playOneRound(allPlayers);
    }

    public void playOneRound(List<Player> players) {

        int tmpMaxRank = -1;
        List<Player> playersWithTopRanks = new ArrayList<>();

        for (Player player : players) {
            player.revealTopCard();
            Card topStagingCard = player.getStaging().peek();
            System.out.println(player.name + " opens " + topStagingCard.toString());
            if (topStagingCard.getRank().ordinal() > tmpMaxRank) {
                tmpMaxRank = topStagingCard.getRank().ordinal();
                playersWithTopRanks.clear();
                playersWithTopRanks.add(player);
            } else if (topStagingCard.getRank().ordinal() == tmpMaxRank) {
                playersWithTopRanks.add(player);
            }
        }

        if (playersWithTopRanks.size() > 1) {
            playOneRound(playersWithTopRanks);
        } else {
            List<Card> cardsForWinner = new ArrayList<>();
            for (Player p : allPlayers) {
                cardsForWinner.addAll(p.giveStagingCards());
            }
            System.out.println("The winner is " + playersWithTopRanks.get(0).name + " and he gets:");
            for (Card card : cardsForWinner) {
                System.out.println(card);
                playersWithTopRanks.get(0).cards.addLast(card);
            }
            players.forEach(p -> System.out.println("After round " + p.name + " has " + p.cards.size() + " cards"));

        }
    }

}

