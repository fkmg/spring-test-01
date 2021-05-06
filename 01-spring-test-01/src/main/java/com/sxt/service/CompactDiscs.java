package com.sxt.service;

public interface CompactDiscs {
    void play(int trackNumber);

    /**
     * 获取乐器的长度
     * @return
     */
    Integer gettracksLength();

}
