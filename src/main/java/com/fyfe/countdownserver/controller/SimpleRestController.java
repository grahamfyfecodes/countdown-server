package com.fyfe.countdownserver.controller;

import com.fyfe.countdownserver.dao.PlayerQueue;
import com.fyfe.countdownserver.model.Message;
import com.fyfe.countdownserver.model.Player;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class SimpleRestController {

    private final SimpMessagingTemplate template;
    private final PlayerQueue playerQueue;
    private final QueueController simpleController;

    public SimpleRestController(SimpMessagingTemplate template, PlayerQueue playerQueue, QueueController simpleController) {
        this.template = template;
        this.playerQueue = playerQueue;
        this.simpleController = simpleController;
    }

    @GetMapping(value = "hello")
    public String hello() throws Exception {
        System.out.println("hello");
        template.convertAndSend("/topic/user", new Message("the server", "oh hi"));
        return "hello";
    }

    @GetMapping(value = "players")
    public List<Player> players() throws Exception {
        return playerQueue.getAllPlayers();
    }
}
