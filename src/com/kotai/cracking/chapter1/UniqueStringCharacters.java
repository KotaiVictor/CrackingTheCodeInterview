package com.kotai.cracking.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * Tests that a string contains just unique characters
 */
public class UniqueStringCharacters {

  public boolean isStringCharacterUnique(String toDetermine) {
    return isStringCharacterUniqueAscii(toDetermine);
  }

  private boolean isStringCharacterUniqueHashSet(String toDetermine) {
    Set<Character> characterSet = new HashSet<>();
    for (char c : toDetermine.toCharArray()) {
      if (characterSet.contains(c))
        return false;
      else
        characterSet.add(c);
    }
    return true;
  }

  private boolean isStringCharacterUniqueStream(String toDetermine) {
    return toDetermine.chars().distinct().count() == toDetermine.length();
  }

  /**
   * relies on the fact that the string contains only unicode characters
   */
  private boolean isStringCharacterUniqueAscii(String toDetermine) {
    if (toDetermine.length() > 128)
      return false;

    boolean[] charSet = new boolean[128];

    for (int i : toDetermine.toCharArray()) {
      if (charSet[i])
        return false;
      charSet[i] = true;
    }
    return true;
  }
}
