package com.kotai.cracking.chapter8.problem3;

import java.util.Set;

public class Jukebox {
  private CDPlayer cdPlayer;
  private Set<CD> cdCollection;

  public Jukebox(CDPlayer cdPlayer, Set<CD> cdCollection) {
    this.cdPlayer = cdPlayer;
    this.cdCollection = cdCollection;
  }

  public Song getCurrentSong() {
    return null;
  }

  public void playNextSong() {}
}
