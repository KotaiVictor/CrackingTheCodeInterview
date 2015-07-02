package com.kotai.cracking.chapter2.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter2.ElementDeleter;
import com.kotai.cracking.samples.TestNode;

public class ElementDeleterTest {

  private ElementDeleter deleter = new ElementDeleter();
  private TestNode<Integer> head;

  @Before
  public void setup() {
    head = new TestNode<>(10);
    head.appendToTail(11);
    head.appendToTail(12);
    head.appendToTail(13);
    head.appendToTail(14);
  }

  @Test
  public void delete_element_at_begining_of_list() {
    deleter.delete(head);

    List<Integer> resultList = new ArrayList<Integer>();
    resultList.add(11);
    resultList.add(12);
    resultList.add(13);
    resultList.add(14);

    assertThat(head.toList(), equalTo(resultList));
  }

  @Test
  public void delete_element_in_middle_of_the_list() {
    TestNode<Integer> toDelete = head.next.next.next; // haha, horrid
    deleter.delete(toDelete);

    List<Integer> resultList = new ArrayList<Integer>();
    resultList.add(10);
    resultList.add(11);
    resultList.add(12);
    resultList.add(14);

    assertThat(head.toList(), equalTo(resultList));
  }
}
