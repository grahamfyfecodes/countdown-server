package com.fyfe.countdownserver.controller;

import com.fyfe.countdownserver.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class SimpleRestController {

    @Autowired
    SimpMessagingTemplate template;

    private final SimpleController simpleController;

    public SimpleRestController(SimpleController simpleController) {
        this.simpleController = simpleController;
    }

    @GetMapping(value = "hello")
    public String hello() throws Exception {
        System.out.println("hello");
        template.convertAndSend("/topic/user", new Message("the server", "oh hi"));
        return "hello";
    }
}
