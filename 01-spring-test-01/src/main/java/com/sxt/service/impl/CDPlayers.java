package com.sxt.service.impl;

import com.sxt.annoation.lh;
import com.sxt.service.CompactDisc;
import com.sxt.service.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CDPlayers implements MediaPlayer {

    @Autowired
    @Qualifier("mm")
    @lh
    private CompactDisc compactDisc;

    public CDPlayers() {

    }

    public CDPlayers(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public CompactDisc getCompactDisc() {
        return compactDisc;
    }

    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
