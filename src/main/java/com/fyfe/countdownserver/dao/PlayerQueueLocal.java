package com.fyfe.countdownserver.dao;

import com.fyfe.countdownserver.model.Player;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class PlayerQueueLocal implements PlayerQueue {

    private final Queue<Player> playerQueue;

    public PlayerQueueLocal() {
        playerQueue = new ConcurrentLinkedDeque<>();
    }

    @Override
    public void addPlayerToQueue(Player player) {
        playerQueue.add(player);
    }

    // TODO potential async issue
    @Override
    public Optional<Pair<Player, Player>> getTwoPlayers() {
        return playerQueue.size() < 2 ? Optional.empty() : Optional.of(createPlayerPair());
    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(playerQueue);
    }

    private Pair<Player, Player> createPlayerPair() {
        return new ImmutablePair<>(playerQueue.remove(), playerQueue.remove());
    }
}
