package com.fyfe.countdownserver.dao;

import com.fyfe.countdownserver.model.Player;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Optional;

public interface PlayerQueue {

    void addPlayerToQueue(Player player);

    Optional<Pair<Player, Player>> getTwoPlayers();

    List<Player> getAllPlayers();
}
