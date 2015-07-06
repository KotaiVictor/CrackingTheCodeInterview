package com.kotai.cracking.chapter2;

import com.kotai.cracking.samples.TestNode;

/*
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of
 * the loop. DEFINITION Circular linked list: A (corrupt) linked list in which a node's next pointer
 * points to an earlier node, so as to make a loop in the linked list. EXAMPLE Input: A
 * ->B->C->D->E- > C [the same C as earlier] Output: C
 */
public class LinkedListCycleFinder {

  public <T> TestNode<T> findCycle(TestNode<T> head) {
    TestNode<T> fastRunner = head;
    TestNode<T> slowRunner = head;

    while (slowRunner != null && fastRunner.next != null) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next.next;
      if (slowRunner == fastRunner)
        break;
    }

    if (fastRunner == null || fastRunner.next == null)
      return null;

    slowRunner = head;
    while (slowRunner != fastRunner) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next;
    }

    return fastRunner;
  }
}
