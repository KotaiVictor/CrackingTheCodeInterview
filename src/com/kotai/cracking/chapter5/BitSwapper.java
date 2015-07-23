package com.kotai.cracking.chapter5;

/*
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and soon
 */
public class BitSwapper {

  public int swap(int number) {
    int oddMask = 0b10101010101010101010101010101010;
    int evenMask = 0b01010101010101010101010101010101;

    return (number & oddMask) >> 1 | (number & evenMask) << 1;
  }

}
