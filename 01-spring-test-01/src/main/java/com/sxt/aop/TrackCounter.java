package com.sxt.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {

    private Map<Integer,Integer> trackMap = new HashMap<>();

    @Pointcut("execution(* com.sxt.service.impl.BlankDiscs.play(int)) && args(trackNumber)")
    public void trackPlay(int trackNumber){}

    @Before("trackPlay(trackNumber)")
    public void countTrack(int trackNumber){
        trackMap.put(trackNumber,getPlayCount(trackNumber)+1);
    }

    public Integer getPlayCount(int trackNumber){

        return trackMap.containsKey(trackNumber) ? trackMap.get(trackNumber):0;
    }
}
