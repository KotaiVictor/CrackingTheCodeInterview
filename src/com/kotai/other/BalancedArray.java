package com.kotai.other;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;

/**
 * Given an array A of N positive numbers. The task is to find the position where equilibrium first
 * occurs in the array. Equilibrium position in an array is a position such that the sum of elements
 * before it is equal to the sum of elements after it.
 */
public class BalancedArray {

  public static int findEquilibrium(int[] input) {
    int rightSum = Arrays.stream(input).sum();
    int leftSum = 0;
    for (int i = 0; i < input.length; i++) {
      rightSum -= input[i];
      if (rightSum == leftSum) {
        return i + 1;
      }
      leftSum += input[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    assertThat(findEquilibrium(new int[]{1, 3, 5, 2, 2}), is(equalTo(3)));
    assertThat(findEquilibrium(new int[]{1}), is(equalTo(1)));
  }
}
