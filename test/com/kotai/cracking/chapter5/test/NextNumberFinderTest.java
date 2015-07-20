package com.kotai.cracking.chapter5.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.kotai.cracking.chapter5.NextNumberFinder;

public class NextNumberFinderTest {

  private NextNumberFinder finder = new NextNumberFinder();

  @Test
  public void check_that_the_finder_works_for_a_simple_test() {
    assertThat(finder.getNext(25), equalTo(26));
    assertThat(finder.getPrevious(25), equalTo(21));
  }

  @Test
  public void check_that_it_words_for_something_more_complicated() {
    assertThat(finder.getNext(13948), equalTo(14072));
    assertThat(finder.getPrevious(13948), equalTo(11900));
  }

  public void check_that_its_bad_for_outliers() {
    fail();
  }
}
