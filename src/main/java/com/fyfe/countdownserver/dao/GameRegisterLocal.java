package com.fyfe.countdownserver.dao;

import com.fyfe.countdownserver.model.Game;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class GameRegisterLocal implements GameRegister {

    private final Map<Integer, Game> gameById;

    public GameRegisterLocal() {
        gameById = new ConcurrentHashMap<>();
    }

    @Override
    public void addGame(Game game) {
        gameById.put(game.getGameId(), game);
    }

    @Override
    public Optional<Game> getGameById(int id) {
        return Optional.ofNullable(gameById.get(id));
    }
}
