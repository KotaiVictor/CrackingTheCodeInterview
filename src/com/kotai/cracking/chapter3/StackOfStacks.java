package com.kotai.cracking.chapter3;

import com.kotai.cracking.samples.TestNode;
import com.kotai.cracking.samples.TestStack;

/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in
 * real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOf Stacks that mimics this. SetOf Stacks should be composed of
 * several stacks and should create a new stack once the previous one exceeds capacity. SetOf
 * Stacks. push() and SetOf Stacks. pop() should behave identically to a single stack (that is, popO
 * should return the same values as it would if there were just a single stack). FOLLOW UP Implement
 * a function popAt(int index) which performs a pop operation on a specific sub-stack
 */
public class StackOfStacks<T> {

  private TestNode<TestStack<T>> stackHead;
  private final int height;

  public StackOfStacks(int maxHeight) {
    this.stackHead = new TestNode<TestStack<T>>(new TestStack<T>());
    this.height = maxHeight;
  }

  public int getStackCount() {
    return stackHead.size();
  }

  public void push(T item) {
    initializeStack();

    boolean canAddToExistingStacks = true;
    TestNode<TestStack<T>> currentNode = stackHead;

    while (canAddToExistingStacks) {
      TestStack<T> currentStack = currentNode.data;
      if (currentStack.size() < height) {
        currentStack.push(item);
        return;
      } else {
        if (currentNode.next == null)
          canAddToExistingStacks = false;
        else
          currentNode = currentNode.next;
      }
    }

    currentNode.next = new TestNode<>(new TestStack<T>());
    currentNode.next.data.push(item);
  }

  private void initializeStack() {
    if (stackHead == null)
      stackHead = new TestNode<>(new TestStack<T>());
  }

  public T pop() {
    TestNode<TestStack<T>> currentNode = stackHead;
    TestNode<TestStack<T>> previousNode = null;
    T toReturn = null;

    while (currentNode != null && toReturn == null) {
      if (shouldRemoveFromNode(currentNode)) {
        toReturn = popAndCollapse(currentNode, previousNode);
      } else {
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
    }

    return toReturn;
  }

  private T popAndCollapse(TestNode<TestStack<T>> currentNode,
      TestNode<TestStack<T>> previousNode) {
    T toReturn = null;
    if (currentNode != null) {
      toReturn = currentNode.data.pop();
      collapseNode(currentNode, previousNode);
    }
    return toReturn;
  }

  private void collapseNode(TestNode<TestStack<T>> currentNode,
      TestNode<TestStack<T>> previousNode) {
    TestStack<T> currentStack = currentNode.data;
    if (currentStack.size() == 0) {
      if (previousNode != null) {
        previousNode.next = currentNode.next;
      } else {
        currentNode = currentNode.next;
      }
    }
  }

  private boolean shouldRemoveFromNode(TestNode<TestStack<T>> currentNode) {
    TestStack<T> currentStack = currentNode.data;
    return (currentStack.size() == height && currentNode.next == null)
        || currentStack.size() != height;
  }

  public T popAt(int stackNumber) {
    if (stackHead == null)
      return null;

    TestNode<TestStack<T>> currentNode = stackHead;
    TestNode<TestStack<T>> previousNode = stackHead;

    while (currentNode != null && stackNumber != 0) {
      previousNode = currentNode;
      currentNode = currentNode.next;
      stackNumber--;
    }

    T toReturn = popAndCollapse(currentNode, previousNode);

    return toReturn;
  }
}
