package com.kotai.cracking.chapter9;

public class RunningChild {

  public int runUp(int numberOfStairs) {
    if (numberOfStairs < 0) {
      return 0;
    } else if (numberOfStairs == 0) {
      return 1;
    }
    return runUp(numberOfStairs - 1) + runUp(numberOfStairs - 2) + runUp(numberOfStairs - 3);
  }

}
