package com.kotai.cracking.chapter8.problem3;

public class CDPlayer {
  private CD currentCD;
  private Playlist playlist;

  public void setCD(CD c) {
    this.currentCD = c;
  }

  public CD getCD() {
    return this.currentCD;
  }

  public Playlist getPlaylist() {
    return this.playlist;
  }

  public void setPlaylist(Playlist p) {
    playlist = p;
  }
}
