package com.sxt.config;

import com.sxt.service.CompactDisc;
import com.sxt.service.MediaPlayer;
import com.sxt.service.impl.CDPlayer;
import com.sxt.service.impl.CDPlayers;
import com.sxt.service.impl.SgtPeppers;
import com.sxt.service.impl.WiteAlbum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CDPlayerConfigx {

    //注册sgtPeppers
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    //注册witeAlbum
    @Bean
    @Primary
    public CompactDisc witeAlbum(){
        return new WiteAlbum();
    }

    @Bean
    public MediaPlayer cDPlayers(){

        return new CDPlayers();
    }

}
