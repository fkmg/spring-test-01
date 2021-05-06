package com.sxt.service.impl;

import com.sxt.service.CompactDisc;

public class BlueAlbum implements CompactDisc {

    private String title = "遇上你是我的缘";

    private String artist = "凤凰传奇";

    @Override
    public void play() {
        System.out.println("Playing "+title +" By "+artist);
    }
}
