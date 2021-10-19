package com.fyfe.countdownserver.controller;

import com.fyfe.countdownserver.dao.PlayerQueue;
import com.fyfe.countdownserver.model.Message;
import com.fyfe.countdownserver.model.OutputMessage;
import com.fyfe.countdownserver.model.Player;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class QueueController {

    private final PlayerQueue playerQueue;

    public QueueController(PlayerQueue playerQueue) {
        this.playerQueue = playerQueue;
    }

    @MessageMapping("/message")
    @SendToUser("/topic/user")
    public OutputMessage send(Message message) throws Exception {
        System.out.println(message.toString());
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

    @MessageMapping("/playerQueue")
    @SendToUser("/topic/user")
    public String addPlayerToQueue(Player player) throws Exception {
        System.out.println("Adding player to queue: " + player.toString());
        playerQueue.addPlayerToQueue(player);
        return "Wah";
    }
}
