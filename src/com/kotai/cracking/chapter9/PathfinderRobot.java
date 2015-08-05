package com.kotai.cracking.chapter9;

/**
 * Imagine a robot sitting on the upper left comer of an X by Y grid. The robot can only move in two
 * directions: right and down. How many possible paths are there for the robot to go from (0, 0) to
 * (X, Y)
 */
public class PathfinderRobot {

  public int findPaths(int x, int y) {
    if (x == 0 || y == 0) {
      return 1;
    }
    return findPaths(x - 1, y) + findPaths(x, y - 1);
  }

}
