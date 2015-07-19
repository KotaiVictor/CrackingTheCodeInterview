package com.kotai.cracking.samples.bitwise;

public class BitwiseUtil {

  /*
   * shift 1 over by i bits, create something that looks like 000100000. AND with num, if != 0 the
   * bit was 1.
   */
  public static boolean getBit(int number, int bitNumber) {
    return ((number & (1 << bitNumber)) != 0);
  }

  /*
   * shift 1 over by i bits, create something that looks like 000100000. OR with num, other bits
   * arent affected
   */
  public static int setBit(int number, int bitNumber) {
    return number | (1 << bitNumber);
  }

  /*
   * Create a mask to remove the required bit, preserving everything else
   */
  public static int clearBit(int number, int bitNumber) {
    int mask = ~(1 << bitNumber);
    return number & mask;
  }

  public static int updateBit(int number, int bitNumber, int value) {
    int mask = ~(1 << bitNumber);
    return (number & mask) | (value << bitNumber);
  }
}
