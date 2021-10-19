package com.fyfe.countdownserver.dao;

import com.fyfe.countdownserver.model.Game;

import java.util.Optional;

public interface GameRegister {

    void addGame(Game game);

    Optional<Game> getGameById(int id);
}
