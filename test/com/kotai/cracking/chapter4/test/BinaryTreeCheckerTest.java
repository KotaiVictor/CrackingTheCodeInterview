package com.kotai.cracking.chapter4.test;

import static com.kotai.cracking.samples.binarytree.BinaryTreeNode.createNode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter4.BinaryTreeChecker;
import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class BinaryTreeCheckerTest {

  private BinaryTreeChecker checker = new BinaryTreeChecker();

  private boolean doCheck(BinaryTreeNode<Integer> root, boolean useInOrder) {
    if (useInOrder)
      return checker.isBinarySearchTree(root);
    return checker.isBST(root);
  }

  @Test
  public void increasing_sequence_of_5_values_is_a_binary_search_tree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
    root.setLeft(createNode(4));
    root.setRight(createNode(16));
    root.getLeft().setLeft(createNode(1));
    root.getLeft().setRight(createNode(6));
    root.getRight().setLeft(createNode(12));
    root.getRight().setRight(createNode(17));

    assertThat(doCheck(root, true), equalTo(true));
    assertThat(doCheck(root, false), equalTo(true));
  }


  @Test
  public void decreasing_sequence_of_5_values_is_not_a_binary_tree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
    root.setLeft(createNode(4));
    root.setRight(createNode(16));
    root.getLeft().setLeft(createNode(1));
    root.getLeft().setRight(createNode(6));
    root.getRight().setLeft(createNode(12));
    root.getRight().setRight(createNode(14));

    assertThat(doCheck(root, true), equalTo(false));
    assertThat(doCheck(root, false), equalTo(false));
  }

  @Test
  public void inner_node_larger_than_root_sequence_is_not_a_binary_tree() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(20);
    root.setLeft(createNode(15));
    root.setRight(createNode(30));
    root.getLeft().setRight(createNode(25));

    assertThat(doCheck(root, true), equalTo(false));
    assertThat(doCheck(root, false), equalTo(false));
  }
}
