package com.leveluptor.drunkard;

public class Launcher {
    public static void main(String[] args) {
        Game game = Game.withPlayers(2);
        game.dealCards();
        game.playOneRound();
//        game.playOneRound();
//        game.playOneRound();
//        game.playOneRound();
    }


}
