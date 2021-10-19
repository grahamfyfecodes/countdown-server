package com.fyfe.countdownserver.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

    private final int playerId;

    @JsonCreator
    public Player(@JsonProperty("playerId") int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + playerId +
                '}';
    }
}
