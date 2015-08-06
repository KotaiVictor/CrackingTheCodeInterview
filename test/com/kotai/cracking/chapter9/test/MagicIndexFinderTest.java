package com.kotai.cracking.chapter9.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.kotai.cracking.chapter9.MagicIndexFinder;

public class MagicIndexFinderTest {

  private MagicIndexFinder indexFinder = new MagicIndexFinder();

  @Test
  public void finder_works_on_array_that_has_index() {
    assertThat(
        indexFinder.findIndex(
            Stream.of(-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13).collect(Collectors.toList())),
        equalTo(7));
  }

  @Test
  public void finder_returns_minus_one_on_array_that_has_no_index() {
    assertThat(
        indexFinder.findIndex(
            Stream.of(-40, -20, -1, 1, 2, 3, 5, 6, 9, 12, 13).collect(Collectors.toList())),
        equalTo(-1));
  }
}
