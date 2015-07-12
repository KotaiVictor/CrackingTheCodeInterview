package com.kotai.cracking.samples.binarytree;

public class BinaryTreeNode<T> {

  private T data;

  private BinaryTreeNode<T> left, right, parent;

  public BinaryTreeNode(T data) {
    this.data = data;
  }

  public BinaryTreeNode<T> getLeft() {
    return left;
  }

  public BinaryTreeNode<T> getRight() {
    return right;
  }

  public void setLeft(BinaryTreeNode<T> child) {
    // ensure child is not an ancestor
    for (BinaryTreeNode<T> ancestor = this; ancestor != null; ancestor = ancestor.parent) {
      if (ancestor == child) {
        throw new IllegalArgumentException("No cicles, please.");
      }
    }

    if (left != null) {
      left.parent = null;
    }

    if (child != null) {
      child.removeFromParent();
      child.parent = this;
    }

    left = child;
  }

  public void setRight(BinaryTreeNode<T> child) {
    for (BinaryTreeNode<T> ancestor = this; ancestor != null; ancestor = ancestor.parent) {
      if (ancestor == child) {
        throw new IllegalArgumentException("No cicles, please.");
      }

      if (right != null) {
        right.parent = null;
      }

      if (child != null) {
        child.removeFromParent();
        child.parent = this;
      }

      right = child;
    }
  }

  public void removeFromParent() {
    if (parent != null) {
      if (parent.left == this) {
        parent.left = null;
      } else if (parent.right == this) {
        parent.right = null;
      }
      parent = null;
    }
  }

  public static <T> BinaryTreeNode<T> createNode(T value) {
    return new BinaryTreeNode<>(value);
  }
}
