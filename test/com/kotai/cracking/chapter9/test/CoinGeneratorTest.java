package com.kotai.cracking.chapter9.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter9.CoinGenerator;

public class CoinGeneratorTest {

  private CoinGenerator changeGenerator = new CoinGenerator();

  @Test
  public void number_of_ways_to_generate_10_cents() {
    assertThat(changeGenerator.generateChange(10, 25), equalTo(4));
  }

  @Test
  public void number_of_ways_to_generate_20_cent() {
    assertThat(changeGenerator.generateChange(20, 25), equalTo(9));
  }

  @Test
  public void number_of_ways_to_generate_25_cents() {
    assertThat(changeGenerator.generateChange(25, 25), equalTo(13));
  }
}
