package com.kotai.cracking.chapter4;

import java.util.List;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

/*
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to
 * create a binary search tree with minimal height.
 */
public class BinaryTreeCreator {

  public <T> BinaryTreeNode<T> createBinaryTreeFromList(List<T> sortedValues) {
    return createNodeFrom(sortedValues, 0, sortedValues.size() - 1);
  }

  private <T> BinaryTreeNode<T> createNodeFrom(List<T> list, int start, int end) {
    if (end < start)
      return null;

    int middle = (start + end) / 2;
    BinaryTreeNode<T> root = new BinaryTreeNode<T>(list.get(middle));
    root.setLeft(createNodeFrom(list, start, middle - 1));
    root.setRight(createNodeFrom(list, middle + 1, end));
    return root;
  }

  public static <T> int height(BinaryTreeNode<T> node) {
    if (node == null)
      return 0;
    return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
  }
}
