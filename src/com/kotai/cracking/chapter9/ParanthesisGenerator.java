package com.kotai.cracking.chapter9;

import java.util.Set;

import com.google.common.collect.Sets;

public class ParanthesisGenerator {

  public Set<String> generateFor(int i) {
    if (i % 2 == 1) {
      return Sets.newHashSet();
    }
    Set<String> generatedSet = Sets.newHashSet();
    if (i == 0) {
      generatedSet.add("");
    } else {
      Set<String> previousSet = generateFor(i - 2);
      for (String solution : previousSet) {
        for (int index = 0; index < solution.length(); index++)
          if (solution.charAt(index) == '(')
            generatedSet.add(insert(solution, index));
        if (!generatedSet.contains("()" + solution))
          generatedSet.add("()" + solution);
      }
    }

    return generatedSet;
  }

  private String insert(String currentString, int index) {
    return currentString.substring(0, index + 1) + "()" + currentString.substring(index + 1);
  }

}
