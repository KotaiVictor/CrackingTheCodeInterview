package com.kotai.cracking.chapter9.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter9.PathfinderRobot;

public class PathfinderRobotTest {

  private PathfinderRobot robot = new PathfinderRobot();

  @Test
  public void number_of_paths_to_origin() {
    assertThat(robot.findPaths(0, 0), equalTo(1));
  }

  @Test
  public void number_of_paths_on_a_0_axis() {
    assertThat(robot.findPaths(0, 10), equalTo(1));
  }

  @Test
  public void number_of_paths_to_a_square_location() {
    assertThat(robot.findPaths(2, 2), equalTo(6));
  }

  @Test
  public void number_of_paths_to_rectangular_location() {
    assertThat(robot.findPaths(2, 3), equalTo(10));
  }

  @Test
  public void number_of_paths_to_further_away_location() {
    assertThat(robot.findPaths(5, 7), equalTo(792));
  }
}
