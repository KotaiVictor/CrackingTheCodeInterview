package com.kotai.cracking.samples;

public class TestStack<T> {
  TestNode<T> top;

  public T pop() {
    T toReturn = null;
    if (top != null) {
      toReturn = top.data;
      top = top.next;
    }
    return toReturn;
  }

  public void push(T item) {
    TestNode<T> newNode = new TestNode<>(item);
    newNode.next = top;
    top = newNode;
  }

  public T peek() {
    if (top != null)
      return top.data;
    return null;
  }
}
