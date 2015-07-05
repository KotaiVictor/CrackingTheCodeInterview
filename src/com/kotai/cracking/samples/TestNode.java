package com.kotai.cracking.samples;

import java.util.ArrayList;
import java.util.List;

public class TestNode<T> {
  public TestNode<T> next = null;
  public T data;

  public TestNode(T data) {
    this.data = data;
  }

  public TestNode<T> appendToTail(T data) {
    TestNode<T> end = new TestNode<T>(data);
    TestNode<T> current = this;
    while (current.next != null) {
      current = current.next;
    }
    current.next = end;

    return this;
  }

  public List<T> toList() {
    List<T> returnList = new ArrayList<T>();

    TestNode<T> current = this;

    do {
      returnList.add(current.data);
      current = current.next;
    } while (current != null);

    return returnList;
  }

  public int size() {
    TestNode<T> head = this;
    int size = 0;
    while (head != null) {
      head = head.next;
      size++;
    }

    return size;
  }

  public TestNode<T> getLast() {
    TestNode<T> last = this;
    while (last.next != null)
      last = last.next;

    return last;
  }

}
