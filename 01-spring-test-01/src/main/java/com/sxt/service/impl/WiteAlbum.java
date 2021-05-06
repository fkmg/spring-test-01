package com.sxt.service.impl;

import com.sxt.service.CompactDisc;

public class WiteAlbum implements CompactDisc {

    private String title = "不要放弃";

    private String artist = "坂泉井水";

    @Override
    public void play() {
        System.out.println("Playing "+title +" By "+artist);
    }
}
