package com.kotai.cracking.chapter4;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a
 * balanced tree is defined to be a tree such that the heights of the two subtrees of any node never
 * differ by more than one
 */

public class BalanceBinaryTreeChecker {

  public boolean isBalanced(BinaryTreeNode<Integer> root) {
    if (root == null || (root.getLeft() == null && root.getRight() == null))
      return true;
    boolean bothSubtreesBalanced = isBalanced(root.getLeft()) && isBalanced(root.getRight());
    boolean heightDifference = Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1;
    return bothSubtreesBalanced && heightDifference;
  }

  private <T> int height(BinaryTreeNode<T> root) {
    if (root == null)
      return 0;
    else
      return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
  }

}
