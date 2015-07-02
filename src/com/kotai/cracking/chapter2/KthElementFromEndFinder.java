package com.kotai.cracking.chapter2;

import com.kotai.cracking.samples.TestNode;

/*
 * Find the kth element from the end of a singly linked list.
 *
 */
public class KthElementFromEndFinder {

  public <T> T findKthFromEndValue(TestNode<T> head, int k) {
    TestNode<T> current = head;
    TestNode<T> runner = head;
    int elementCount = 0;
    while (runner.next != null) {
      if (elementCount >= k) {
        current = current.next;
      }
      runner = runner.next;
      elementCount++;
    }

    return elementCount >= k ? current.data : null;
  }
}
