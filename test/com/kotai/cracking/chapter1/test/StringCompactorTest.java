package com.kotai.cracking.chapter1.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter1.StringCompactor;

public class StringCompactorTest {

  private StringCompactor compactor;

  @Before
  public void setUp() throws Exception {
    compactor = new StringCompactor();
  }

  @Test
  public void compact_reduces_size_of_string() {
    assertThat(compactor.compact("aaaabbbcccc"), equalTo("a4b3c4"));
  }

  @Test
  public void compactWOB_reduces_size_of_string() {
    assertThat(compactor.compactWithoutStringBuffer("aaaabbbccccc"), equalTo("a4b3c5"));
  }

  @Test
  public void compact_returns_initial_string_if_cant_reduce_size() {
    assertThat(compactor.compact("abc"), equalTo("abc"));
    assertThat(compactor.compact("a"), equalTo("a"));
  }
}
