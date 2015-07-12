package com.kotai.cracking.chapter3;

import com.kotai.cracking.samples.TestStack;

/*
 * Write a program to sort a stack in ascending order (with biggest items on top). You may use at
 * most one additional stack to hold items, but you may not copy the elements into any other data
 * structure (such as an array). The stack supports the following operations: push, pop, peek, and
 * isEmpty.
 */
public class SortedStack<T extends Comparable<T>> {
  private TestStack<T> sortedStack, backupStack;

  public SortedStack() {
    sortedStack = new TestStack<>();
    backupStack = new TestStack<>();
  }

  public boolean isEmpty() {
    return sortedStack.peek() == null;
  }

  public void push(T value) {
    if (sortedStack.peek() == null) {
      sortedStack.push(value);
    } else {
      while (sortedStack.peek() != null && value.compareTo(sortedStack.peek()) > 0) {
        backupStack.push(sortedStack.pop());
      }
      sortedStack.push(value);
      while (backupStack.peek() != null) {
        sortedStack.push(backupStack.pop());
      }
    }
  }

  public T pop() {
    return sortedStack.pop();
  }

  public T peek() {
    return sortedStack.peek();
  }


}
