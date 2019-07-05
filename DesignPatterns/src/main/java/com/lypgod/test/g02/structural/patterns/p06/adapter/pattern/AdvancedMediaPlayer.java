package com.lypgod.test.g02.structural.patterns.p06.adapter.pattern;

/**
 * @author richard
 */
public interface AdvancedMediaPlayer {
   /**
    * playVlc
    * @param fileName String
    */
   void playVlc(String fileName);

   /**
    * playMp4
    * @param fileName String
    */
   void playMp4(String fileName);
}