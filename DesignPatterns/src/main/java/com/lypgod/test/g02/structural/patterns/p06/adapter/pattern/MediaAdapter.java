package com.lypgod.test.g02.structural.patterns.p06.adapter.pattern;

/**
 * @author richard
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMusicPlayer;

    MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase(MEDIA_TYPE_VLC)) {
            advancedMusicPlayer = new VlcPlayer();
        }

        if (audioType.equalsIgnoreCase(MEDIA_TYPE_MP4)) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase(MEDIA_TYPE_VLC)) {
            advancedMusicPlayer.playVlc(fileName);
        }
        if (audioType.equalsIgnoreCase(MEDIA_TYPE_MP4)) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}