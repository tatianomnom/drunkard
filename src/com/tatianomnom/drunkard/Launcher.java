package com.tatianomnom.drunkard;

/**
 * Created by tatiana on 18.12.14.
 */
public class Launcher {
    public static void main(String[] args) {
        Game game = Game.withPlayers(4);
        game.dealCards();
        game.playOneRound();
        game.playOneRound();
        game.playOneRound();
        game.playOneRound();
    }


}
