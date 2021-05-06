package com.sxt.service.impl;

import com.sxt.service.CompactDisc;
import com.sxt.service.MediaPlayer;

public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
