package com.kotai.cracking.chapter2;

import com.kotai.cracking.samples.TestNode;

/*
 * Implement a function to check if a linked list is a palindrome
 */
public class PalindromeCheck<T extends Comparable<T>> {

  public boolean testPalindrome(TestNode<T> node) {
    TestNode<T> reverseNode = reverse(node);

    while (reverseNode != null && node != null) {
      if (reverseNode.data.compareTo(node.data) != 0)
        return false;
      reverseNode = reverseNode.next;
      node = node.next;
    }
    return true;
  }

  private TestNode<T> reverse(TestNode<T> node) {
    TestNode<T> result = null;

    while (node != null) {
      TestNode<T> current = new TestNode<>(node.data);
      current.next = result;
      result = current;
      node = node.next;
    }

    return result;
  }
}
