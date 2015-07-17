package com.kotai.cracking.chapter4.test;

import static com.kotai.cracking.samples.binarytree.BinaryTreeNode.createNode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter4.CommonAncestorFinder;
import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class CommonAncestorFindertTest {

  private CommonAncestorFinder ancestorFinder = new CommonAncestorFinder();

  private BinaryTreeNode<Integer> node1, node2, node3, root, node5, node6, node7;

  @Before
  public void setup() {
    root = createNode(4);
    node2 = createNode(2);
    root.setLeft(node2);
    node6 = createNode(6);
    root.setRight(node6);

    node3 = createNode(3);
    node1 = createNode(1);
    node2.setLeft(node1);
    node2.setRight(node3);

    node5 = createNode(5);
    node7 = createNode(7);
    node6.setLeft(node5);
    node6.setRight(node7);
  }

  @Test
  public void find_common_ancestor_of_leafs_on_same_side_left() {
    assertThat(ancestorFinder.findCommonAncestor(root, node3, node1), equalTo(node2));
  }

  @Test
  public void find_common_ancestor_of_leafs_on_same_side_right() {
    assertThat(ancestorFinder.findCommonAncestor(root, node7, node5), equalTo(node6));
  }

  @Test
  public void find_common_ancestor_of_leafs_on_different_sides() {
    assertThat(ancestorFinder.findCommonAncestor(root, node1, node6), equalTo(root));
  }

  @Test
  public void find_common_ancestor_of_left_side_leaf_and_root() {
    assertThat(ancestorFinder.findCommonAncestor(root, node1, root), equalTo(root));
  }

  @Test
  public void find_common_ancestor_of_right_side_leaf_and_root() {
    assertThat(ancestorFinder.findCommonAncestor(root, node7, root), equalTo(root));
  }

  @Test
  public void find_common_ancestor_of_intermediary_node_and_leaf_different_sides() {
    assertThat(ancestorFinder.findCommonAncestor(root, node2, node5), equalTo(root));
  }
}
