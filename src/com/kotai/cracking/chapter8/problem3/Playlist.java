package com.kotai.cracking.chapter8.problem3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Playlist {
  private String name;
  private Queue<Song> songs = new LinkedList<>();

  public Playlist(String name, Collection<Song> songs) {
    this.name = name;
    this.songs.addAll(songs);
  }

  public void enqueueSong(Song s) {
    songs.add(s);
  }
}
