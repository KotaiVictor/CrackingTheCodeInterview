package com.kotai.cracking.chapter5;

import java.util.List;

import com.google.common.collect.Lists;

/*
 * An array A contains all the integers from 0 through n, except for one number which is missing. In
 * this problem, we cannot access an entire integer in A with a single operation. The elements of A
 * are represented in binary, and the only operation we can use to access them is
 * "fetch the jth bit of A[i]," which takes constant time. Write code to find the missing integer.
 * Can you do it in 0(n) time
 */
public class MissingElementFinder {

  public int findMissing(List<String> inputList) {
    if (inputList.isEmpty())
      return 0;
    return findMissing(inputList, inputList.get(0).length() - 1);
  }

  private int findMissing(List<String> inputList, int column) {
    if (column < 0)
      return 0;

    List<String> oneBits = Lists.newArrayList();
    List<String> zeroBits = Lists.newArrayList();

    for (String value : inputList)
      if (value.charAt(column) == '0')
        zeroBits.add(value);
      else
        oneBits.add(value);

    if (zeroBits.size() <= oneBits.size()) {
      return (findMissing(zeroBits, column - 1) << 1) | 0;
    } else {
      return (findMissing(oneBits, column - 1) << 1) | 1;
    }
  }

}
