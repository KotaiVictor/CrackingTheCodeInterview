package com.kotai.cracking.samples;

public class TestStack<T> {
  protected TestNode<T> top;

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
    return top == null ? null : top.data;
  }

  public int size() {
    return top == null ? 0 : top.size();
  }
}
