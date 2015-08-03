package com.kotai.cracking.chapter3;

/**
 * How would you design a stack which, in addition to push and pop, also has a function min which
 * returns the minimum element? Push, pop and min should all operate in O(1) time
 */
public class StackThatKnowsMin<T extends Comparable<T>> {
  private MinNode top;

  public void push(T value) {
    if (top == null) {
      top = new MinNode(value, value);
    } else {
      T newMin = value.compareTo(top.min) < 0 ? value : top.min;
      MinNode newNode = new MinNode(value, newMin);
      newNode.next = top;
      top = newNode;
    }
  }

  public T min() {
    T min = null;
    if (top != null)
      min = top.min;
    return min;
  }

  public T pop() {
    T toReturn = null;
    if (top != null) {
      toReturn = top.data;
      top = top.next;
    }
    return toReturn;
  }

  private class MinNode {
    private MinNode next = null;
    private T min;
    private T data;

    public MinNode(T data, T min) {
      this.data = data;
      this.min = min;
    }
  }
}
