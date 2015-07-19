package com.kotai.cracking.chapter5.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter5.NumberMixer;

public class NumberMixerTest {
  private NumberMixer mixer = new NumberMixer();

  @Test
  public void second_number_is_correctly_inserted_into_first() {
    // EXAMPLE Input: N = 10000000000, M = 10011, i = 2, j = 6 Output: N = 10001001100
    assertThat(mixer.insertNumbers(1024, 19, 2, 6), equalTo(1100));
  }
}
