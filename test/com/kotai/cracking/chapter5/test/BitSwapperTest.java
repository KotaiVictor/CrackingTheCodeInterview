package com.kotai.cracking.chapter5.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter5.BitSwapper;

public class BitSwapperTest {
  private BitSwapper bitSwapper = new BitSwapper();

  @Test
  public void check_that_swapper_works() {
    assertThat(bitSwapper.swap(7), equalTo(11));
    assertThat(bitSwapper.swap(11), equalTo(7));
    assertThat(bitSwapper.swap(0), equalTo(0));
  }
}
