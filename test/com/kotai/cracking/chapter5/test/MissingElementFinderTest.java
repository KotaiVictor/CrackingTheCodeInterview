package com.kotai.cracking.chapter5.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.kotai.cracking.chapter5.MissingElementFinder;

public class MissingElementFinderTest {

  private MissingElementFinder finder = new MissingElementFinder();

  @Test
  public void find_missing_element_in_list() {
    assertThat(finder.findMissing(Stream.of(0, 2, 1, 4, 5, 7, 6).map(n -> {
      return String.format("%3s", Integer.toBinaryString(n)).replace(' ', '0');
    }).collect(Collectors.toList())), equalTo(3));

  }
}
