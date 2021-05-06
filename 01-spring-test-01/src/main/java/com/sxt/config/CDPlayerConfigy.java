package com.sxt.config;

import com.sxt.annoation.bqjs;
import com.sxt.annoation.lh;
import com.sxt.service.CompactDisc;
import com.sxt.service.MediaPlayer;
import com.sxt.service.impl.BlueAlbum;
import com.sxt.service.impl.CDPlayers;
import com.sxt.service.impl.SgtPeppers;
import com.sxt.service.impl.WiteAlbum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CDPlayerConfigy {

    //注册sgtPeppers
    @Bean
    @Qualifier("sg")
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    //注册witeAlbum
    @Bean
    @Qualifier("mm")
    @bqjs
    public CompactDisc witeAlbum(){
        return new WiteAlbum();
    }

    @Bean
    @Qualifier("mm")
    @lh
    public CompactDisc blueAlbum(){
        return new BlueAlbum();
    }
    @Bean
    public MediaPlayer cDPlayers(){

        return new CDPlayers();
    }

}
