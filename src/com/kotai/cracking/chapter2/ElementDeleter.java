package com.kotai.cracking.chapter2;

import com.kotai.cracking.samples.TestNode;

/*
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access
 * to that node. EXAMPLE Input: the node c from the linked list a->b->c->d->e Result: nothing is
 * returned, but the new linked list looks like a- >b- >d->e
 */
public class ElementDeleter {

  /**
   * can't delete the last node in the list
   */
  public <T> void delete(TestNode<T> head) {
    TestNode<T> current = head;

    while (current.next != null) {
      current.data = current.next.data;
      if (current.next.next == null)
        current.next = null;
      else
        current = current.next;
    }
  }

}
