package com.kotai.cracking.chapter5;

/*
 * Given a positive integer, print the next smallest and the next largest number that have the same
 * number of 7 bits in their binary representation.
 */
public class NextNumberFinder {

  public int getNext(int number) {
    char[] binaryRepresentation = Integer.toBinaryString(number).toCharArray();
    int current = binaryRepresentation.length - 1;

    while (binaryRepresentation[current] == '0') {
      current--;
    }
    number -= Math.pow(2, binaryRepresentation.length - 1 - current--);

    while (binaryRepresentation[current] == '1') {
      current--;
    }
    number += Math.pow(2, binaryRepresentation.length - 1 - current);

    return number;
  }

  public int getPrevious(int number) {
    char[] binaryRepresentation = Integer.toBinaryString(number).toCharArray();
    int current = 0;
    while (binaryRepresentation[current] == '1') {
      current++;
    }
    if (current > 0)
      number -= Math.pow(2, binaryRepresentation.length - 1 - current + 1);
    number += Math.pow(2, binaryRepresentation.length - 1 - current);

    return number;
  }
}
