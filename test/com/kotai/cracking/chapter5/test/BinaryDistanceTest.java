package com.kotai.cracking.chapter5.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter5.BinaryDistance;

public class BinaryDistanceTest {

  private BinaryDistance measurer = new BinaryDistance();

  @Test
  public void distance_between_number_and_itself_is_0() {
    assertThat(measurer.getDistanceBetween(10, 10), equalTo(0));
  }

  @Test
  public void distance_between_power_of_2_and_0_is_1() {
    assertThat(measurer.getDistanceBetween(1024, 0), equalTo(1));
  }

  @Test
  public void distance_between_some_random_numbers() {
    assertThat(measurer.getDistanceBetween(14, 31), equalTo(2));
  }

  @Test
  public void distance_function_is_symmetric() {
    assertThat(measurer.getDistanceBetween(14, 31), equalTo(measurer.getDistanceBetween(31, 14)));
  }
}
