package com.kotai.cracking.chapter2.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter2.ElementDeleter;
import com.kotai.cracking.samples.TestNode;

public class ElementDeleterTest {

  private ElementDeleter deleter = new ElementDeleter();
  private TestNode<Integer> head;

  @Before
  public void setup() {
    head = new TestNode<>(10).appendToTail(11).appendToTail(12).appendToTail(13).appendToTail(14);
  }

  @Test
  public void delete_element_at_begining_of_list() {
    deleter.delete(head);

    TestNode<Integer> resultNode =
        new TestNode<>(11).appendToTail(12).appendToTail(13).appendToTail(14);

    assertThat(head.toList(), equalTo(resultNode.toList()));
  }

  @Test
  public void delete_element_in_middle_of_the_list() {
    TestNode<Integer> toDelete = head.next.next.next; // haha, horrid
    deleter.delete(toDelete);

    TestNode<Integer> resultNode =
        new TestNode<Integer>(10).appendToTail(11).appendToTail(12).appendToTail(14);

    assertThat(head.toList(), equalTo(resultNode.toList()));
  }
}
