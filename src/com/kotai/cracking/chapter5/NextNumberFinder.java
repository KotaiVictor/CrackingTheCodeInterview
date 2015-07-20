package com.kotai.cracking.chapter5;

/*
 * Given a positive integer, print the next smallest and the next largest number that have the same
 * number of 7 bits in their binary representation.
 */
/**
 * this should still handle outliers, kinda shitty solution... I'm sure there's a better one
 * involving bit manipulation but that is just mind bogling at this hour
 */
public class NextNumberFinder {

  public int getNext(int number) {
    char[] binaryRepresentation = Integer.toBinaryString(number).toCharArray();
    int current = binaryRepresentation.length - 1;
    while (binaryRepresentation[current] == '0') {
      current--;
    }
    binaryRepresentation[current--] = '0';
    while (binaryRepresentation[current] == '1') {
      current--;
    }
    binaryRepresentation[current] = '1';

    return Integer.parseInt(new String(binaryRepresentation), 2);
  }

  public int getPrevious(int number) {
    char[] binaryRepresentation = Integer.toBinaryString(number).toCharArray();
    int current = 0;
    while (binaryRepresentation[current] == '1') {
      current++;
    }
    binaryRepresentation[current - 1] = '0';
    binaryRepresentation[current] = '1';

    return Integer.parseInt(new String(binaryRepresentation), 2);
  }
}
