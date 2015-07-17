package com.kotai.cracking.chapter4;

import java.util.ArrayList;
import java.util.List;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

public class BinaryTreeChecker {
  public <T extends Comparable<T>> boolean isBinarySearchTree(BinaryTreeNode<T> root) {
    List<BinaryTreeNode<T>> inOrderList = inOrderTraversal(root);
    BinaryTreeNode<T> previous = null;
    for (BinaryTreeNode<T> current : inOrderList) {
      if (previous != null && current.getData().compareTo(previous.getData()) <= 0)
        return false;
      previous = current;
    }
    return true;
  }

  /**
   * So ineficient
   */
  private <T extends Comparable<T>> List<BinaryTreeNode<T>> inOrderTraversal(
      BinaryTreeNode<T> root) {
    ArrayList<BinaryTreeNode<T>> list = new ArrayList<>();
    if (root == null)
      return list;
    list.addAll(inOrderTraversal(root.getLeft()));
    list.add(root);
    list.addAll(inOrderTraversal(root.getRight()));
    return list;
  }

  public boolean isBST(BinaryTreeNode<Integer> root) {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinarySearchTree(BinaryTreeNode<Integer> root, Integer min, Integer max) {
    if (root == null)
      return true;

    if (root.getData() <= min || root.getData() > max)
      return false;

    boolean isBinaryTreeLeft = isBinarySearchTree(root.getLeft(), min, root.getData());

    boolean isBinaryTreeRight = isBinarySearchTree(root.getRight(), root.getData(), max);

    return isBinaryTreeLeft && isBinaryTreeRight;
  }
}
