package com.kotai.cracking.chapter4;

import com.kotai.cracking.samples.binarytree.BinaryTreeNode;

/*
 * Find an algorithm to find the next node "in order successor" of a given node in a binary search tree.
 * Each node has a link to its parent.
 */
public class NextNodeFinder {

	public <T extends Comparable<T>> BinaryTreeNode<T> findNext(BinaryTreeNode<T> node) {
		if (node.getLeft() == null && node.getParent().getLeft() == node)
			return node.getParent();
		
		if (node.getRight() == null && node.getParent().getRight() == node) {
			BinaryTreeNode<T> root = node;
			while (root.getParent() != null) {
				root = root.getParent();
			}
			// need to decide if right side of tree or left side
			if (node.getData().compareTo(root.getData()) <=0)
				return root;
			else
				return null;
		}

		BinaryTreeNode<T> innerLeft = node.getRight();
		while (innerLeft.getLeft() != null)
			innerLeft = innerLeft.getLeft();
		
		return innerLeft;
	}
}
