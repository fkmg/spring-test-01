package com.sxt.service.impl;

import com.sxt.service.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt.Peper's Lonely Hearts Club Band";
    
    private String artist = "The Beatles";
    
    @Override
    public void play() {
        System.out.println("Playing "+title +" By "+artist);
    }
}
