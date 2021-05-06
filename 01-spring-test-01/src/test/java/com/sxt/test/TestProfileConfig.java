package com.sxt.test;

import com.sxt.config.SgtPeppersConfig;
import com.sxt.config.WiteAlbumConfig;
import com.sxt.service.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SgtPeppersConfig.class, WiteAlbumConfig.class})
@ActiveProfiles("profile")
public class TestProfileConfig {

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void testCompactDisc(){
        compactDisc.play();
    }

}
