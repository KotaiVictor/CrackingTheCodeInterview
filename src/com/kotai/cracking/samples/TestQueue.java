package com.kotai.cracking.samples;

public class TestQueue<T> {
  TestNode<T> first, last;

  public void enqueue(T item) {
    TestNode<T> newNode = new TestNode<>(item);
    if (first == null) {
      first = last = newNode;
    } else {
      last.next = newNode;
      last = last.next;
    }
  }

  public T dequeue() {
    T toReturn = null;
    if (first != null) {
      toReturn = first.data;
      first = first.next;
    }
    return toReturn;
  }
}
