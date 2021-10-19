package com.fyfe.countdownserver.config;

import com.fyfe.countdownserver.dao.GameRegister;
import com.fyfe.countdownserver.dao.GameRegisterLocal;
import com.fyfe.countdownserver.dao.PlayerQueue;
import com.fyfe.countdownserver.dao.PlayerQueueLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalConfig {

    @Bean
    public PlayerQueue playerQueue() {
        return new PlayerQueueLocal();
    }

    @Bean
    public GameRegister gameRegister() {
        return new GameRegisterLocal();
    }
}
