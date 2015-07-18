package com.kotai.cracking.chapter4.test;

import static com.kotai.cracking.samples.binarytree.BinaryTreeNode.createNode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter4.TreeSubtreeChecker;
import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class TreeSubtreeCheckerTree {

  private TreeSubtreeChecker treeChecker = new TreeSubtreeChecker();

  private BinaryTreeNode<Integer> largeTreeRoot;
  private BinaryTreeNode<Integer> smallTreeRootContained;
  private BinaryTreeNode<Integer> smallTreeRootNotContained;


  @Before
  public void setup() {
    smallTreeRootContained = createNode(5);
    smallTreeRootContained.setLeft(createNode(3));
    smallTreeRootContained.setRight(createNode(7));

    smallTreeRootNotContained = createNode(5);
    smallTreeRootNotContained.setLeft(createNode(3));
    smallTreeRootNotContained.setRight(createNode(6));

    largeTreeRoot = createNode(10);
    largeTreeRoot.setLeft(createNode(9));
    largeTreeRoot.getLeft().setLeft(smallTreeRootContained);
    largeTreeRoot.setRight(createNode(20));
    largeTreeRoot.getRight().setLeft(createNode(15));
    largeTreeRoot.getRight().setRight(createNode(25));
  }

  @Test
  public void checker_finds_contained_smaller_tree_in_larger_one() {
    assertThat(treeChecker.isContained(smallTreeRootContained, largeTreeRoot), equalTo(true));
  }

  @Test
  public void checker_cant_find_not_contained_smaller_tree_in_larger_one() {
    assertThat(treeChecker.isContained(smallTreeRootNotContained, largeTreeRoot), equalTo(false));
  }
}
