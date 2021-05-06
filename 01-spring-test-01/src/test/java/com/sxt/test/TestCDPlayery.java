package com.sxt.test;

import com.sxt.config.CDPlayerConfigy;
import com.sxt.service.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDPlayerConfigy.class})
public class TestCDPlayery {

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void testPlay(){
        mediaPlayer.play();
    }
}
