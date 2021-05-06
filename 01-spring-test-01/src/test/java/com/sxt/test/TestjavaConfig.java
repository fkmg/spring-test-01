package com.sxt.test;

import com.sxt.config.CDPlayerConfig;
import com.sxt.config.CDPlayerConfigs;
import com.sxt.service.MediaPlayer;
import com.sxt.service.impl.CDPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfigs.class)
public class TestjavaConfig {

    @Autowired
    private MediaPlayer cdPlayer;

    @Test
    public void testCDPlayer(){
        cdPlayer.play();
    }
}
