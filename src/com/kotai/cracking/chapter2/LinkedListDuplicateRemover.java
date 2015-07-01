package com.kotai.cracking.chapter2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.kotai.cracking.samples.TestNode;

public class LinkedListDuplicateRemover {

  public <T> LinkedList<T> deDuplicateStream(LinkedList<T> inputList) {
    return Lists.newLinkedList(inputList.parallelStream().distinct().collect(Collectors.toList()));
  }

  /**
   * Does the work in O(n) with an additional data structure with a possible max size of n
   */
  public <T> TestNode<T> deDuplicate(TestNode<T> head) {
    Set<T> uniqueSet = new HashSet<T>();
    TestNode<T> current = head;
    TestNode<T> previous = null;

    while (current != null) {
      if (uniqueSet.contains(current.data))
        previous.next = current.next;
      else {
        uniqueSet.add(current.data);
        previous = current;
      }
      current = current.next;
    }
    return head;
  }

  public <T> TestNode<T> deDuplicateWithoutAccumulator(TestNode<T> head) {
    TestNode<T> current = head;

    while (current != null) {
      TestNode<T> runner = current;
      while (runner.next != null) {
        if (current.data == runner.next.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
    return head;
  }
}
