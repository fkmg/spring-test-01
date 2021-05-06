package com.sxt.config;

import com.sxt.aop.TrackCounter;
import com.sxt.service.CompactDiscs;
import com.sxt.service.impl.BlankDiscs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:/app.properties")
public class TrackCountConfig {

    @Autowired
    private Environment ev;

    @Bean
    public CompactDiscs BlankDiscs(){

        BlankDiscs cd = new BlankDiscs(ev.getProperty("disc.title"),ev.getProperty("disc.artists","孤独的灵魂"));

        List<String> tracks = new ArrayList<>();

        tracks.add("Woodwinds");
        tracks.add("Piccolo");
        tracks.add("Flute");
        tracks.add("Soprano Recorder");
        tracks.add("Oboe");
        tracks.add("Brass");

        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
}
