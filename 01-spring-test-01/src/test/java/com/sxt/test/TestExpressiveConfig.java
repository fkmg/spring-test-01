package com.sxt.test;

import com.sxt.config.ExpressiveConfig;
import com.sxt.service.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExpressiveConfig.class)
public class TestExpressiveConfig {

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void testExpressiveConfig(){
        compactDisc.play();
    }
}
