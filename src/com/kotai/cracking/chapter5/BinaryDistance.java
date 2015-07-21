package com.kotai.cracking.chapter5;

/*
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * EXAMPLE Input: 31,14 Output: 2
 */
public class BinaryDistance {

  public int getDistanceBetween(int first, int second) {
    int count = 0;
    for (int acc = first ^ second; acc != 0; acc = acc & (acc - 1))
      count++;
    return count;
  }

}
