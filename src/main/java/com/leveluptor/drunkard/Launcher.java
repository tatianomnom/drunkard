package com.leveluptor.drunkard;

public class Launcher {
    public static void main(String[] args) {
        Game game = Game.withPlayers(4);
        game.dealCards();

        while (true) {
            game.playOneRound();
        }
    }


}
