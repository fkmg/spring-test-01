package com.sxt.config;

import com.sxt.service.CompactDisc;
import com.sxt.service.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("profile")
public class SgtPeppersConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
}
