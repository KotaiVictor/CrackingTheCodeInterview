package com.kotai.cracking.chapter9;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Write a method to compute all permutations of a string
 */
public class StringPermutation {

  public List<String> generatePermutations(String inputString) {
    if (inputString == null)
      return null;

    List<String> allPermutations = Lists.newArrayList();
    if (inputString.length() == 0) {
      allPermutations.add("");
      return allPermutations;
    }

    Character firstChar = inputString.charAt(0);
    String remainder = inputString.substring(1);
    List<String> previousPermutations = generatePermutations(remainder);
    for (String word : previousPermutations) {
      for (int index = 0; index <= word.length(); index++) {
        allPermutations.add(insertCharAt(firstChar, index, word));
      }
    }
    return allPermutations;
  }

  private String insertCharAt(Character character, int index, String word) {
    return word.substring(0, index) + character + word.substring(index);
  }
}
