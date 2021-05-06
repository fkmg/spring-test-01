package com.sxt.config;

import com.sxt.service.CompactDisc;
import com.sxt.service.impl.SgtPeppers;
import com.sxt.service.impl.WiteAlbum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class WiteAlbumConfig {

    @Bean
    public CompactDisc witeAlbum(){
        return new WiteAlbum();
    }
}
