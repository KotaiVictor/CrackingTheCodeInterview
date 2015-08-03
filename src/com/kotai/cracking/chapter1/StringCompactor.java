package com.kotai.cracking.chapter1;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import org.apache.commons.lang3.StringUtils;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string.
 */
public class StringCompactor {

  public String compact(String toCompact) {
    StringBuffer accumulator = new StringBuffer();
    if (StringUtils.isNotEmpty(toCompact)) {
      Character currentChar = toCompact.charAt(0);
      int characterCount = 1;
      for (int index = 1; index < toCompact.length(); index++) {
        if (currentChar == toCompact.charAt(index)) {
          characterCount++;
        } else {
          accumulator.append(currentChar + EMPTY + characterCount);
          currentChar = toCompact.charAt(index);
          characterCount = 1;
        }
      }
      if (characterCount != 0) {
        accumulator.append(currentChar + EMPTY + characterCount);
      }
    }
    return accumulator.length() < toCompact.length() ? accumulator.toString() : toCompact;
  }

  public String compactWithoutStringBuffer(String toCompact) {
    int inputStringLength = toCompact.length();
    char[] chars = new char[inputStringLength];
    if (StringUtils.isNotEmpty(toCompact)) {
      Character currentChar = toCompact.charAt(0);
      int currentIndex = 0;
      int charCount = 1;
      for (int index = 1; index < inputStringLength; index++) {
        if (currentChar == toCompact.charAt(index)) {
          charCount++;
        } else {
          if (currentIndex + 2 > inputStringLength)
            return toCompact;
          else
            currentIndex = addToArray(chars, currentChar, charCount, currentIndex);
          currentChar = toCompact.charAt(index);
          charCount = 1;
        }
      }
      if (currentIndex + 2 > inputStringLength)
        return toCompact;
      else
        currentIndex = addToArray(chars, currentChar, charCount, currentIndex);
    }

    return new String(chars).trim();
  }

  private int addToArray(char[] chars, char character, int number, int index) {
    chars[index++] = character;
    chars[index++] = Character.forDigit(number, 10);
    return index;
  }
}
