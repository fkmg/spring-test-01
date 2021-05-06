package com.sxt.test;

import com.sxt.aop.TrackCounter;
import com.sxt.config.TrackCountConfig;
import com.sxt.service.CompactDiscs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TrackCountConfig.class})
public class TestTrackCount {

    @Autowired
    private CompactDiscs cd;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testTrackCount(){

        Integer val = -1;

        for(int i=0;i<10;i++){
            val = (int) Math.floor(Math.random() * cd.gettracksLength());
            cd.play(val);
        }

        for(int i = 0; i< cd.gettracksLength();i++){
            System.out.println("第 "+i+"个乐器被用了"+trackCounter.getPlayCount(i)+"次");
        }



    }
}
