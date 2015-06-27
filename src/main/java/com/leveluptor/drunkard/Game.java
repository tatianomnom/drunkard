package com.leveluptor.drunkard;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Deck deck = new Deck();

    List<Player> players = new ArrayList<>();

    public static Game withPlayers(int numberOfPlayers) {

        Game game = new Game();
        for (int i = 0; i < numberOfPlayers; i++) {
            List<Player> gamePlayers = game.players;
            gamePlayers.add(new Player("Player " + i));
        }

        return game;
    }

    public void dealCards() {
        deck.shuffle();
        while (deck.cards.size() >= players.size()) {
            for (Player player : players) {
                player.cards.add(deck.cards.pop());
            }
        }
    }

    public void playOneRound() {
        Card.Rank temporaryMaxRank = null;
        List<Player> playersWithTopCard = new ArrayList<>();
        List<Card> cardsInCurrentRound = new ArrayList<>();
        for (Player player : players) {
            player.revealTopCard();
            Card card = player.getStaging().peek();

            System.out.println(player.name + " opens " + card.toString());

            cardsInCurrentRound.add(card);

            if (temporaryMaxRank == null) {
                temporaryMaxRank = card.getRank();
            }

            //чето тут не то
            if (card.getRank().compareTo(temporaryMaxRank) >= 0) {
                if (card.getRank().compareTo(temporaryMaxRank) > 0) {
                    playersWithTopCard.clear();
                    System.out.println("Temporary max rank becomes " + temporaryMaxRank.toString());
                }
                temporaryMaxRank = card.getRank();
                System.out.println("Player with top card: " + player.name);
                playersWithTopCard.add(player);
            }
        }

        playersWithTopCard.get(0).cards.addAll(cardsInCurrentRound);
    }

}

