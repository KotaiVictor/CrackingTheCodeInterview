package com.kotai.cracking.chapter2;

import com.kotai.cracking.samples.TestNode;

/*
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x.
 */
public class ElementPartitioner {

  public <T extends Comparable<T>> TestNode<T> partition(TestNode<T> head, T value) {
    TestNode<T> leftHead = null;
    TestNode<T> leftCurrent = null;
    TestNode<T> rightHead = null;
    TestNode<T> rightCurrent = null;

    while (head != null) {
      if (value.compareTo(head.data) > 0) {
        if (leftHead == null) {
          leftCurrent = leftHead = new TestNode<T>(head.data);
        } else {
          leftCurrent.next = new TestNode<T>(head.data);
          leftCurrent = leftCurrent.next;
        }
      } else {
        if (rightHead == null) {
          rightCurrent = rightHead = new TestNode<T>(head.data);
        } else {
          rightCurrent.next = new TestNode<T>(head.data);
          rightCurrent = rightCurrent.next;
        }
      }
      head = head.next;
    }

    if (leftHead != null) {
      leftCurrent.next = rightHead;
      return leftHead;
    }
    return rightHead;
  }

  public <T extends Comparable<T>> TestNode<T> partition2(TestNode<T> node, T value) {
    TestNode<T> head = node;
    TestNode<T> tail = node;

    while (node != null) {
      TestNode<T> next = node.next;
      if (value.compareTo(node.data) > 0) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }

      node = next;
    }
    tail.next = null;

    return head;
  }
}
