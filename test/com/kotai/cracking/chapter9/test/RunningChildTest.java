package com.kotai.cracking.chapter9.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter9.RunningChild;

public class RunningChildTest {

  private RunningChild child = new RunningChild();

  @Test
  public void run_up_one_stair() {
    assertThat(child.runUp(1), equalTo(1));
  }

  @Test
  public void run_up_two_stairs() {
    assertThat(child.runUp(2), equalTo(2));
  }

  @Test
  public void run_up_three_stairs() {
    assertThat(child.runUp(3), equalTo(4));
  }

  @Test
  public void run_up_a_lotta_stairs() {
    assertThat(child.runUp(10), equalTo(274));
  }
}
