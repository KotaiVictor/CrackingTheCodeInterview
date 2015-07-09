package com.kotai.cracking.samples;

public class TestStack<T> {
  private TestNode<T> top;

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
    T peekedValue = null;
    if (top != null)
      peekedValue = top.data;
    return peekedValue;
  }

  public int size() {
    int size = 0;
    if (top != null)
      size = top.size();
    return size;
  }
}
