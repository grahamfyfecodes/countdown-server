package com.fyfe.countdownserver;

import com.fyfe.countdownserver.controller.SimpleController;
import com.fyfe.countdownserver.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountdownServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountdownServerApplication.class, args);
	}
}
