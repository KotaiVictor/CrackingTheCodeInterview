package com.kotai.cracking.chapter3;

import com.kotai.cracking.samples.TestStack;

/*
 * Implement a MyQueue class which implements a queue using two stacks
 */

public class TwoStackQueue<T> {

  private TestStack<T> regular, reversed;

  public TwoStackQueue() {
    regular = new TestStack<>();
    reversed = new TestStack<>();
  }

  public void enqueue(T value) {
    regular.push(value);
  }

  public T dequeue() {
    T toReturn = null;
    moveAll(regular, reversed);
    toReturn = reversed.pop();
    moveAll(reversed, regular);
    return toReturn;
  }

  public T peek() {
    T toReturn = null;
    moveAll(regular, reversed);
    toReturn = reversed.peek();
    moveAll(reversed, regular);
    return toReturn;
  }

  private void moveAll(TestStack<T> fromStack, TestStack<T> toStack) {
    while (fromStack.peek() != null) {
      toStack.push(fromStack.pop());
    }
  }
}
