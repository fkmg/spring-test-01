package com.sxt.config;

import com.sxt.service.CompactDisc;
import com.sxt.service.impl.CDPlayer;
import com.sxt.service.impl.SgtPeppers;
import com.sxt.service.impl.WiteAlbum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfigs {

    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(randomBeatlesCD());
    }

    @Bean
    public CompactDisc randomBeatlesCD(){

        CompactDisc compactDisc = null;

        int choice = (int) Math.floor(Math.random()*3);
        switch (choice){
            case 0:{
                compactDisc = new SgtPeppers();
                break;
            }
            case 1:{
                compactDisc = new WiteAlbum();
            }
        }
        return compactDisc;
    }
}
