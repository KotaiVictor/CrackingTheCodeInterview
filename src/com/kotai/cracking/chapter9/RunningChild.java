package com.kotai.cracking.chapter9;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at
 * a time. Implement a method to count how many possible ways the child can run up the stairs
 */
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
