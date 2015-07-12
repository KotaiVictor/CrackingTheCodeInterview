package com.kotai.cracking.chapter4.test;

import static com.kotai.cracking.samples.binarytree.BinaryTreeNode.createNode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter4.BalanceBinaryTreeChecker;
import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class BalanceBinaryTreeCheckerTest {

  private BalanceBinaryTreeChecker balanceChecker = new BalanceBinaryTreeChecker();

  @Test
  public void a_one_node_tree_is_balanced() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
    assertThat(balanceChecker.isBalanced(root), equalTo(true));
  }

  @Test
  public void a_two_level_complete_tree_is_balanced() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
    root.setLeft(createNode(5));
    root.setRight(createNode(15));

    assertThat(balanceChecker.isBalanced(root), equalTo(true));
  }

  @Test
  public void a_two_level_almost_complete_tree_is_balanced() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
    root.setLeft(createNode(5));

    assertThat(balanceChecker.isBalanced(root), equalTo(true));
  }

  @Test
  public void a_three_level_complete_tree_is_balanced() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
    BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(5);
    BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(15);

    root.setLeft(left);
    root.setRight(right);

    left.setLeft(createNode(2));
    left.setRight(createNode(7));

    right.setLeft(createNode(12));
    right.setRight(createNode(17));

    assertThat(balanceChecker.isBalanced(root), equalTo(true));
  }

  @Test
  public void right_growing_tree_is_not_balanced() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
    root.setRight(createNode(12));
    root.getRight().setRight(createNode(14));
    root.getRight().getRight().setRight(createNode(16)); // yuck

    assertThat(balanceChecker.isBalanced(root), equalTo(false));
  }
}
