package com.leveluptor.drunkard;

public class Launcher {
    public static void main(String[] args) {
        Game game = Game.withPlayers(4);
        game.dealCards();

        for (int i = 0; i < 10; i++) {
            game.playOneRound();
        }
    }


}
