package com.kotai.cracking.chapter4;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class BinaryTreeChecker {

  public <T extends Comparable<T>> boolean isBinarySearchTree(BinaryTreeNode<T> root) {
    if (root == null)
      return true;

    boolean isBinaryTreeLeft = true;
    if (root.getLeft() != null)
      isBinaryTreeLeft = isBinarySearchTree(root.getLeft())
          && root.getLeft().getData().compareTo(root.getData()) <= 0;

    boolean isBinaryTreeRight = true;
    if (root.getRight() != null)
      isBinaryTreeRight = isBinarySearchTree(root.getRight())
          && root.getRight().getData().compareTo(root.getData()) >= 0;

    return isBinaryTreeLeft && isBinaryTreeRight;
  }
}
