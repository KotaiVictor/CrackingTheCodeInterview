package com.kotai.cracking.chapter8.problem2;

public enum Rank {
  RESPONDER(1), MANAGER(2), DIRECTOR(3);

  private int rankLevel;

  private Rank(int rankLevel) {
    this.rankLevel = rankLevel;
  }

  public int getRank() {
    return this.rankLevel;
  }

  public static Rank getRankForLevel(int level) {
    switch (level) {
      case 1:
        return Rank.RESPONDER;
      case 2:
        return Rank.MANAGER;
      case 3:
      default:
        return Rank.DIRECTOR;
    }
  }
}
