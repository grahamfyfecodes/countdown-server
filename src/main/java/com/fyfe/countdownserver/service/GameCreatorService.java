package com.fyfe.countdownserver.service;

import com.fyfe.countdownserver.dao.GameRegister;
import com.fyfe.countdownserver.dao.PlayerQueue;
import com.fyfe.countdownserver.model.Game;
import com.fyfe.countdownserver.model.Player;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

@Service
public class GameCreatorService {

    private final PlayerQueue playerQueue;
    private final GameRegister gameRegister;

    public GameCreatorService(PlayerQueue playerQueue, GameRegister gameRegister) {
        this.playerQueue = playerQueue;
        this.gameRegister = gameRegister;
    }

    private void getPlayersAndCreateGame() {
        playerQueue.getTwoPlayers().ifPresent(this::createGameWithPlayers);
    }

    private void createGameWithPlayers(Pair<Player, Player> players) {
        Game game = createGame(players.getLeft(), players.getRight());
        gameRegister.addGame(game);
    }

    private Game createGame(Player playerA, Player playerB) {
        // TODO game Id and letters
        int gameId = 101;
        String letters = "sdfsaeidfh";
        return new Game(gameId, playerA, playerB, letters);
    }


}
