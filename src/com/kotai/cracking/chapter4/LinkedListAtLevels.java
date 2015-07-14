package com.kotai.cracking.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

/*
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each
 * depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

public class LinkedListAtLevels {

  public <T> List<List<T>> getLevelsFromLinkedList(BinaryTreeNode<T> root) {
    List<List<T>> resultList = new ArrayList<>();
    if (root != null) {
      List<BinaryTreeNode<T>> currentLevel = Stream.of(root).collect(Collectors.toList());
      while (!currentLevel.isEmpty()) {
        List<BinaryTreeNode<T>> nextLevel = new ArrayList<>();
        for (BinaryTreeNode<T> node : currentLevel) {
          if (node.getLeft() != null)
            nextLevel.add(node.getLeft());

          if (node.getRight() != null)
            nextLevel.add(node.getRight());
        }
        resultList
            .add(currentLevel.stream().map(BinaryTreeNode::getData).collect(Collectors.toList()));
        currentLevel = nextLevel;
      }
    }

    return resultList;
  }
}
