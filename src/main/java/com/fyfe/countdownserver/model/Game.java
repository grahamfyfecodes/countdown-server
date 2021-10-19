package com.fyfe.countdownserver.model;

public class Game {

    private final int gameId;
    private final Player playerAId;
    private final Player playerBId;
    private final String letters;

    public Game(int gameId, Player playerAId, Player playerBId, String letters) {
        this.gameId = gameId;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
        this.letters = letters;
    }

    public int getGameId() {
        return gameId;
    }

    public Player getPlayerAId() {
        return playerAId;
    }

    public Player getPlayerBId() {
        return playerBId;
    }

    public String getLetters() {
        return letters;
    }
}
