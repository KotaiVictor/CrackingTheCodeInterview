package com.kotai.cracking.chapter2.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.kotai.cracking.chapter2.ElementPartitioner;
import com.kotai.cracking.samples.TestNode;

public class ElementPartitionerTest {

  private ElementPartitioner partitioner = new ElementPartitioner();

  @Test
  public void list_case_value_in_list() {
    TestNode<Integer> head = new TestNode<>(14);
    head.appendToTail(13);
    head.appendToTail(12);
    head.appendToTail(11);
    head.appendToTail(10);

    List<Integer> expectedList = new ArrayList<Integer>();
    expectedList.add(11);
    expectedList.add(10);
    expectedList.add(14);
    expectedList.add(13);
    expectedList.add(12);

    assertThat(partitioner.partition(head, 12).toList(), equalTo(expectedList));
  }

  @Test
  public void list_case_value_less_than_list() {
    TestNode<Integer> head = new TestNode<Integer>(10);
    head.appendToTail(11);
    head.appendToTail(12);
    head.appendToTail(13);

    assertThat(partitioner.partition(head, 9).toList(), equalTo(head.toList()));
  }

  @Test
  public void list_case_value_greater_than_list() {
    TestNode<Integer> head = new TestNode<Integer>(10);
    head.appendToTail(11);
    head.appendToTail(12);
    head.appendToTail(13);

    assertThat(partitioner.partition(head, 14).toList(), equalTo(head.toList()));
  }

  @Test
  public void empty_list_case() {
    assertThat(partitioner.partition(null, 10), equalTo(null));
  }

  @Test
  public void one_element_case_value_greater_than_whole_list() {
    TestNode<Integer> head = new TestNode<Integer>(10);

    assertThat(partitioner.partition(head, 11).toList(), equalTo(head.toList()));
  }

  @Test
  public void one_element_case_value_less_than_list() {
    TestNode<Integer> head = new TestNode<Integer>(10);
    assertThat(partitioner.partition(head, 8).toList(), equalTo(head.toList()));
  }

  @Test
  public void list_case_for_partition2() {
    TestNode<Integer> head = new TestNode<>(14);
    head.appendToTail(13);
    head.appendToTail(12);
    head.appendToTail(11);
    head.appendToTail(10);

    List<Integer> expectedList = new ArrayList<Integer>();
    expectedList.add(10);
    expectedList.add(11);
    expectedList.add(14);
    expectedList.add(13);
    expectedList.add(12);

    assertThat(partitioner.partition2(head, 12).toList(), equalTo(expectedList));

  }
}
