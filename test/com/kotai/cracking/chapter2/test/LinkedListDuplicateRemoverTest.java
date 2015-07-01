package com.kotai.cracking.chapter2.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.kotai.cracking.chapter2.LinkedListDuplicateRemover;
import com.kotai.cracking.samples.TestNode;

public class LinkedListDuplicateRemoverTest {

  private LinkedListDuplicateRemover duplicateRemover = new LinkedListDuplicateRemover();

  @Test
  public void list_with_1_element_gets_deduplicated_with_stream() {
    LinkedList<Integer> integerList = new LinkedList<>();
    integerList.add(10);

    assertTrue(integerList.equals(duplicateRemover.deDuplicateStream(integerList)));
  }

  @Test
  public void nodeList_with_1_element_gets_deduplicated() {
    TestNode<Integer> head = new TestNode<Integer>(10);
    List<Integer> expectedResult = new ArrayList<Integer>();
    expectedResult.add(10);

    assertThat(duplicateRemover.deDuplicate(head).toList(), equalTo(expectedResult));
  }

  @Test
  public void list_with_multiple_elements_gets_deduplicated_stream() {
    LinkedList<Integer> integerList = new LinkedList<>();
    integerList.add(10);
    integerList.add(10);
    integerList.add(121);
    integerList.add(11);
    integerList.add(10);
    integerList.add(121);

    LinkedList<Integer> expectedList = new LinkedList<>();
    expectedList.add(10);
    expectedList.add(121);
    expectedList.add(11);

    assertThat(duplicateRemover.deDuplicateStream(integerList), equalTo(expectedList));
  }

  @Test
  public void list_with_multiple_elements_gets_deduplicated() {
    TestNode<Integer> head = new TestNode<Integer>(10);
    head.appendToTail(10);
    head.appendToTail(10);
    head.appendToTail(121);
    head.appendToTail(11);
    head.appendToTail(10);
    head.appendToTail(121);
    head.appendToTail(11);

    LinkedList<Integer> expectedList = new LinkedList<>();
    expectedList.add(10);
    expectedList.add(121);
    expectedList.add(11);

    assertThat(duplicateRemover.deDuplicate(head).toList(), equalTo(expectedList));
  }

  @Test
  public void list_with_multiple_elements_gets_deduplicated_without_accumulator() {
    TestNode<Integer> head = new TestNode<Integer>(10);
    head.appendToTail(10);
    head.appendToTail(10);
    head.appendToTail(121);
    head.appendToTail(11);
    head.appendToTail(10);
    head.appendToTail(121);
    head.appendToTail(11);

    LinkedList<Integer> expectedList = new LinkedList<>();
    expectedList.add(10);
    expectedList.add(121);
    expectedList.add(11);

    assertThat(duplicateRemover.deDuplicateWithoutAccumulator(head).toList(),
        equalTo(expectedList));
  }
}
