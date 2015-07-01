package com.kotai.cracking.chapter2.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter2.KthElementFromEndFinder;
import com.kotai.cracking.samples.TestNode;

public class KthElementFromEndFinderTest {

  private KthElementFromEndFinder finder = new KthElementFromEndFinder();
  private TestNode<Integer> head;

  @Before
  public void setUp() {
    head = new TestNode<>(1);
    head.appendToTail(2);
    head.appendToTail(3);
    head.appendToTail(4);
    head.appendToTail(5);
  }

  @Test
  public void find_kth_element_in_a_larger_than_k_list() {
    assertThat(finder.findKthFromEndValue(head, 1), equalTo(4));
  }

  @Test
  public void find_end_in_list() {
    assertThat(finder.findKthFromEndValue(head, 0), equalTo(5));
  }

  @Test
  public void find_incorrect_value_returns_null() {
    assertThat(finder.findKthFromEndValue(head, 6), equalTo(null));
  }
}
