package com.fyfe.countdownserver.controller;

import com.fyfe.countdownserver.model.Message;
import com.fyfe.countdownserver.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SimpleController {

    @MessageMapping("/message")
    @SendToUser("/topic/user")
    public OutputMessage send(Message message) throws Exception {
        System.out.println(message.toString());
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
