package com.sxt.service.impl;

import com.sxt.service.CompactDisc;

public class BlankDisc implements CompactDisc {

    private String title ;

    private String artist;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing "+title +" By "+artist);
    }
}
