package com.kotai.cracking.chapter4;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

/*
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary
 * tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary
 * search tree.
 */
public class CommonAncestorFinder {

  public <T> BinaryTreeNode<T> findCommonAncestor(BinaryTreeNode<T> root, BinaryTreeNode<T> first,
      BinaryTreeNode<T> second) {
    if (root == first || root == second)
      return root;

    boolean isFirstInLeftSubtree = isInSubTree(root.getLeft(), first);
    boolean isSecondInLeftSubtree = isInSubTree(root.getLeft(), second);

    if (isFirstInLeftSubtree != isSecondInLeftSubtree)
      return root;

    if (isFirstInLeftSubtree && isSecondInLeftSubtree)
      return findCommonAncestor(root.getLeft(), first, second);
    else
      return findCommonAncestor(root.getRight(), first, second);

  }

  private <T> boolean isInSubTree(BinaryTreeNode<T> root, BinaryTreeNode<T> element) {
    if (root == null)
      return false;

    return root == element || isInSubTree(root.getLeft(), element)
        || isInSubTree(root.getRight(), element);
  }
}

