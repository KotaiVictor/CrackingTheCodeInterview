package com.kotai.other;

/**
 * Given an array arr[] of N non-negative integers representing height of blocks
 * at index i as Ai where the width of each block is 1. Compute how much water
 * can be trapped in between blocks after raining.
 */
public class RainCatcher {

  public static int calculateRain(int[] input) {
    int[] left = new int[input.length];
    int[] right = new int[input.length];

    left[0] = input[0];
    for (int i = 1; i < input.length; i++) {
      left[i] = Integer.max(input[i], left[i - 1]);
    }

    right[input.length - 1] = input[input.length - 1];
    for (int i = input.length - 2; i >= 0; i--) {
      right[i] = Integer.max(right[i + 1], input[i]);
    }
    int water = 0;
    for (int i = 0; i < input.length; i++) {
      water += Integer.min(left[i], right[i]) - input[i];
    }
    return water;
  }

  public static void main(String[] args) {
    System.out.println(calculateRain(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
  }
}
