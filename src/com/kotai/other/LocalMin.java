package com.kotai.other;

import static org.apache.commons.lang3.math.NumberUtils.max;
import static org.apache.commons.lang3.math.NumberUtils.min;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.*;

/**
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
 */
public class LocalMin {

  public static int findMinimum(int[] inputArray) {
    int maxDiff = -1;
    for (int i = 0; i < inputArray.length; i++) {
      for (int j = inputArray.length - 1; j > i; j--) {
        if (inputArray[j] > inputArray[i] && maxDiff < (j - i)) {
          maxDiff = j - i;
        }
      }
    }
    return maxDiff;
  }

  /**
   * Generate helper arrays that will contain to the left of position i the min up to and including
   * that position and another one to the right of i maximum value including i
   */
  public static int findMinimum2(int[] inputArray) {
    int length = inputArray.length;
    int maxDiff = -1;
    int maxR[] = new int[length];
    int minL[] = new int[length];

    minL[0] = inputArray[0];
    for (int i = 1; i < length; i++) {
      minL[i] = min(inputArray[i], minL[i - 1]);
    }

    maxR[length - 1] = inputArray[length - 1];
    for (int i = length - 2; i >= 0; i--) {
      maxR[i] = max(inputArray[i], maxR[i + 1]);
    }
    int i = 0, j = 0;
    while (j < length && i < length) {
      if (minL[i] < maxR[j]) {
        maxDiff = max(maxDiff, j - i);
        j++;
      } else {
        i++;
      }
    }
    return maxDiff;
  }

  public static void main(String[] args) {
    assertThat(findMinimum2(new int[]{1, 2, 3, 4}), is(equalTo(3)));
    assertThat(findMinimum2(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}), is(equalTo(6)));
  }
}

