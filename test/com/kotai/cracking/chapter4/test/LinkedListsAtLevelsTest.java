package com.kotai.cracking.chapter4.test;

import static com.kotai.cracking.samples.binarytree.BinaryTreeNode.createNode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.kotai.cracking.chapter4.LinkedListAtLevels;
import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class LinkedListsAtLevelsTest {

  private LinkedListAtLevels levelLister = new LinkedListAtLevels();

  @Test
  public void a_3_element_complete_list_will_have_2_level() {
    BinaryTreeNode<Integer> root = createNode(10);
    root.setLeft(createNode(5));
    root.setRight(createNode(12));

    List<List<Integer>> levelLists = levelLister.getLevelsFromLinkedList(root);
    assertThat(levelLists.size(), equalTo(2));
    assertThat(levelLists.get(0), equalTo(Stream.of(10).collect(Collectors.toList())));
    assertThat(levelLists.get(1), equalTo(Stream.of(5, 12).collect(Collectors.toList())));
  }

  @Test
  public void a_5_element_complete_list_will_have_4_levels() {
    BinaryTreeNode<Integer> root = createNode(15);
    root.setLeft(createNode(5));
    root.setRight(createNode(20));
    root.getRight().setRight(createNode(25));
    root.getRight().getRight().setRight(createNode(30));

    List<List<Integer>> levelLists = levelLister.getLevelsFromLinkedList(root);
    assertThat(levelLists.size(), equalTo(4));
    assertThat(levelLists.get(0), equalTo(Stream.of(15).collect(Collectors.toList())));
    assertThat(levelLists.get(1), equalTo(Stream.of(5, 20).collect(Collectors.toList())));
    assertThat(levelLists.get(2), equalTo(Stream.of(25).collect(Collectors.toList())));
    assertThat(levelLists.get(3), equalTo(Stream.of(30).collect(Collectors.toList())));
  }

  @Test
  public void an_empty_list_will_have_no_levels() {
    List<List<Integer>> levelLists = levelLister.getLevelsFromLinkedList(null);
    assertThat(levelLists.isEmpty(), equalTo(true));
  }
}
