package com.sxt.config;

import com.sxt.service.impl.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/app.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment ev;

    @Bean
    public BlankDisc blankDisc(){

        return new BlankDisc(ev.getProperty("disc.title"),ev.getProperty("disc.artists","孤独的灵魂"));
    }

}
