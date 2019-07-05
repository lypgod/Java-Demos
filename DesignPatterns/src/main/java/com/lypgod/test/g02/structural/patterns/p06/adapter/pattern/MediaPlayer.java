package com.lypgod.test.g02.structural.patterns.p06.adapter.pattern;

/**
 * @author richard
 */
public interface MediaPlayer {
    String MEDIA_TYPE_VLC = "VLC";
    String MEDIA_TYPE_MP4 = "MP4";
    String MEDIA_TYPE_MP3 = "MP3";

    /**
     * play
     * @param audioType String
     * @param fileName String
     */
    void play(String audioType, String fileName);
}