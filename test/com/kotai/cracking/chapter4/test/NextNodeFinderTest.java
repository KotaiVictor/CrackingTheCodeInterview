package com.kotai.cracking.chapter4.test;

import static com.kotai.cracking.samples.binarytree.BinaryTreeNode.createNode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter4.BinaryTreeChecker;
import com.kotai.cracking.chapter4.NextNodeFinder;
import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class NextNodeFinderTest {

  private NextNodeFinder finder = new NextNodeFinder();
  private BinaryTreeNode<Integer> generatedRoot = new BinaryTreeNode<>(6);
  private BinaryTreeNode<Integer> node1, node2, node3, node4, node5, node7, node8, node9;

  @Before
  /*
   *            6
   *    2               7
   * 1      4               9    
   *     3     5        8
   * 
   * inorder 1 2 3 4 5 6 7 8 9
   */
  public void setup() {
    node1 = createNode(1); // the overkill
    node2 = createNode(2);
    node3 = createNode(3);
    node4 = createNode(4);
    node5 = createNode(5);
    node7 = createNode(7);
    node8 = createNode(8);
    node9 = createNode(9);

    generatedRoot.setLeft(node2);
    node2.setLeft(node1);

    node2.setRight(node4);
    node4.setLeft(node3);
    node4.setRight(node5);

    generatedRoot.setRight(node7);
    node7.setRight(node9);
    node9.setLeft(node8);
  }

  @Test
  public void the_ive_created_a_binary_tree_test() {
    BinaryTreeChecker checker = new BinaryTreeChecker();
    assertThat(checker.isBinarySearchTree(generatedRoot), equalTo(true));
  }

  @Test
  public void check_that_next_for_rightmost_leaf_returns_null() {
    assertThat(finder.findNext(node9), equalTo(null));
  }

  @Test
  public void check_that_next_for_root_returns_right_side_inner_leftmost() {
    assertThat(finder.findNext(generatedRoot).getData(), equalTo(7));
  }

  @Test
  public void check_that_next_on_a_left_leaf_returns_the_parent() {
    assertThat(finder.findNext(node1).getData(), equalTo(2));
  }

  @Test
  public void check_that_next_on_left_side_right_most_returns_root() {
    assertThat(finder.findNext(node5).getData(), equalTo(6));
  }

  @Test
  public void check_that_next_on_node_with_both_left_and_right_nodes_returns_right_side_leftmost() {
    assertThat(finder.findNext(node2).getData(), equalTo(3));
  }

  @Test
  public void check_that_in_order_traversal_works() {
    assertThat(finder.findNext(node1).getData(), equalTo(2));
    assertThat(finder.findNext(node2).getData(), equalTo(3));
    assertThat(finder.findNext(node3).getData(), equalTo(4));
    assertThat(finder.findNext(node4).getData(), equalTo(5));
    assertThat(finder.findNext(node5).getData(), equalTo(6));
    assertThat(finder.findNext(generatedRoot).getData(), equalTo(7));
    assertThat(finder.findNext(node7).getData(), equalTo(8));
    assertThat(finder.findNext(node8).getData(), equalTo(9));
    assertThat(finder.findNext(node9), equalTo(null));
  }
}
