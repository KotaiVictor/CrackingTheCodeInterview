package com.kotai.cracking.chapter2;

import com.kotai.cracking.samples.TestNode;

/*
 * You have two numbers represented by a linked list, where each node contains a single digit. The
 * digits are stored in reverse order, such that the Ts digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list. EXAMPLE Input: (7-> 1 ->
 * 6) + (5 -> 9 -> 2).That is, 617 + 295. Output: 2 -> 1 -> 9.That is, 912. FOLLOW UP Suppose the
 * digits are stored in forward order. Repeat the above problem. EXAMPLE Input: (6 -> 1 -> 7) + (2
 * -> 9 -> 5).That is, 617 + 295. Output: 9 -> 1 -> 2.That is, 912.
 */
public class LinkedListAdder {

  public TestNode<Integer> addReverse(TestNode<Integer> firstNumber,
      TestNode<Integer> secondNumber) {
    if (firstNumber == null && secondNumber == null)
      return new TestNode<Integer>(0);
    if (firstNumber == null)
      return secondNumber;
    if (secondNumber == null)
      return firstNumber;

    TestNode<Integer> resultNumberHead = addNodes(firstNumber, secondNumber, 0);
    int carryOver = normalizeNode(resultNumberHead);
    TestNode<Integer> resultNumberBody = resultNumberHead;

    while (firstNumber.next != null || secondNumber.next != null) {
      firstNumber = firstNumber.next;
      secondNumber = secondNumber.next;
      resultNumberBody.next = addNodes(firstNumber, secondNumber, carryOver);
      resultNumberBody = resultNumberBody.next;
      carryOver = normalizeNode(resultNumberBody);
    }

    if (carryOver != 0)
      resultNumberBody.next = new TestNode<Integer>(carryOver);

    return resultNumberHead;
  }

  private Integer normalizeNode(TestNode<Integer> resultNumber) {
    int carryOver = resultNumber.data / 10;
    resultNumber.data = resultNumber.data % 10;
    return carryOver;
  }

  private TestNode<Integer> addNodes(TestNode<Integer> firstNode, TestNode<Integer> secondNode,
      int carryOver) {
    Integer accumulator = carryOver;
    if (firstNode != null)
      accumulator += firstNode.data;

    if (secondNode != null)
      accumulator += secondNode.data;

    return new TestNode<Integer>(accumulator);
  }
}
