package com.kotai.cracking.chapter9;

import java.util.List;

/**
 * A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] = i. Given a
 * sorted array of distinct integers, write a method to find a magic index, if one exists, in array
 * A.
 * 
 */
public class MagicIndexFinder {

  public int findIndex(List<Integer> collect) {
    return findIndex(collect.toArray(new Integer[collect.size()]), 0, collect.size() - 1);
  }

  private int findIndex(Integer[] array, int start, int end) {
    if (end < start || start < 0 || end > array.length)
      return -1;

    int mid = (start + end) / 2;
    if (array[mid] == mid) {
      return mid;
    } else if (array[mid] > mid) {
      return findIndex(array, start, mid - 1);
    } else {
      return findIndex(array, mid + 1, end);
    }
  }

}
