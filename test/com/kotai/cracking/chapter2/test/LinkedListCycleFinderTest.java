package com.kotai.cracking.chapter2.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter2.LinkedListCycleFinder;
import com.kotai.cracking.samples.TestNode;

public class LinkedListCycleFinderTest {

  private LinkedListCycleFinder finder = new LinkedListCycleFinder();

  @Test
  public void find_cycle_in_a_linked_list() {
    TestNode<Integer> head =
        new TestNode<Integer>(10).appendToTail(11).appendToTail(12).appendToTail(13);
    TestNode<Integer> cycleHead = head.getLast().next = head.next; // 10 -> 11 -> 12 -> 13 -> 11

    assertThat(finder.findCycle(head), equalTo(cycleHead));
  }

  @Test
  public void no_cycle_in_linked_list() {
    TestNode<Integer> head = new TestNode<Integer>(10).appendToTail(11).appendToTail(12)
        .appendToTail(13).appendToTail(14);

    assertThat(finder.findCycle(head), equalTo(null));
  }
}
