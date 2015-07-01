package com.kotai.cracking.chapter1;

import org.apache.commons.lang3.StringUtils;

/**
 * Should compact strings
 */
public class StringCompactor {

  public String compact(String toCompact) {
    StringBuffer accumulator = new StringBuffer();
    if (!StringUtils.isEmpty(toCompact)) {
      Character currentChar = toCompact.charAt(0);
      int characterCount = 1;
      for (int index = 1; index < toCompact.length(); index++) {
        if (currentChar == toCompact.charAt(index)) {
          characterCount++;
        } else {
          accumulator.append(currentChar + "" + characterCount);
          currentChar = toCompact.charAt(index);
          characterCount = 1;
        }
      }
      if (characterCount != 0) {
        accumulator.append(currentChar + "" + characterCount);
      }
    }
    return accumulator.length() < toCompact.length() ? accumulator.toString() : toCompact;
  }

  public String compactWithoutStringBuffer(String toCompact) {
    char[] chars = new char[toCompact.length()];
    if (!StringUtils.isEmpty(toCompact)) {
      Character currentChar = toCompact.charAt(0);
      int resultIndex = 0;
      int charCount = 1;
      for (int index = 1; index < toCompact.length(); index++) {
        if (currentChar == toCompact.charAt(index)) {
          charCount++;
        } else {
          if (resultIndex + 2 > toCompact.length())
            return toCompact;
          else
            resultIndex = addToArray(chars, currentChar, charCount, resultIndex);
          currentChar = toCompact.charAt(index);
          charCount = 1;
        }
      }
      if (resultIndex + 2 > toCompact.length())
        return toCompact;
      else
        resultIndex = addToArray(chars, currentChar, charCount, resultIndex);
    }

    return new String(chars).trim();
  }

  private int addToArray(char[] chars, char character, int number, int index) {
    chars[index++] = character;
    chars[index++] = Character.forDigit(number, 10);
    return index;
  }
}
