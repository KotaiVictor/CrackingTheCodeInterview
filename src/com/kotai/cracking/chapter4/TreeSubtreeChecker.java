package com.kotai.cracking.chapter4;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

/*
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide ifT2 is a subtree of Tl. A tree T2 is a subtree of Tl if there
 * exists a node n in Tl such that the subtree of n is identical to T2. That is, if you cut off the
 * tree at node n, the two trees would be identical.
 */
public class TreeSubtreeChecker {

  public <T extends Comparable<T>> boolean isContained(BinaryTreeNode<T> searchTree,
      BinaryTreeNode<T> tree) {
    if (searchTree == null)
      return false;
    return subTree(searchTree, tree);
  }

  private <T extends Comparable<T>> boolean subTree(BinaryTreeNode<T> searchNode,
      BinaryTreeNode<T> node) {
    if (node == null)
      return false;

    if (searchNode.getData().compareTo(node.getData()) == 0)
      return matchTree(searchNode, node);

    return subTree(searchNode, node.getLeft()) || subTree(searchNode, node.getRight());
  }

  private <T extends Comparable<T>> boolean matchTree(BinaryTreeNode<T> searchNode,
      BinaryTreeNode<T> node) {
    if (searchNode == null && node == null)
      return true;

    if (searchNode == null || node == null)
      return false;

    if (searchNode.getData().compareTo(node.getData()) != 0)
      return false;
    else
      return matchTree(searchNode.getLeft(), node.getLeft())
          && matchTree(searchNode.getRight(), node.getRight());
  }

}
