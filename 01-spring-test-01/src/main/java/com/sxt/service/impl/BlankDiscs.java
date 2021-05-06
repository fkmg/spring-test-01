package com.sxt.service.impl;

import com.sxt.service.CompactDiscs;

import java.util.List;

public class BlankDiscs implements CompactDiscs {

    private String title ;

    private String artist;

    private List<String> tracks;

    public BlankDiscs() {

    }

    public BlankDiscs(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    /**获取乐器的长度**/
    @Override
    public Integer gettracksLength(){

        return tracks== null ?0 :tracks.size();
    }

    @Override
    public void play(int trackNumber) {
        if(tracks !=null && tracks.size() > 0){
            System.out.println("Playing "+title +" By "+artist +"\tusing "+tracks.get(trackNumber));
        }
    }
}
