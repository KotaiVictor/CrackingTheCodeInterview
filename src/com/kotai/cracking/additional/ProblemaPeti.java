package com.kotai.cracking.additional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemaPeti {

  public static void main(String[] args) {
    long l = System.nanoTime();
    List<String> results = generateNeighbours(555515555);
//    results.stream().forEach(element -> System.out.print(element + " "));
    System.out.println(results.size());
    long now = System.nanoTime();

    System.out.println(now - l);
  }

  public static List<String> generateNeighbours(int pinNumber) {
    String number = String.valueOf(pinNumber);
    int length = number.length() - 1;
    Set<String> solutions = new HashSet<>();
    solutions.add(number);
    for (int i = 0; i <= length; i++) {
      Set<String> newLevel = new HashSet<>(solutions);
      for (String solution : newLevel) {
        int currentDigit = Character.digit(number.charAt(i), 10);
        int currentSolution = Integer.parseInt(solution);
        switch (currentDigit) {
          case 1:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 1, i)));
            break;
          case 2:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 1, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -1, i)));
            break;
          case 3:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -1, i)));
            break;
          case 4:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 1, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -3, i)));
            break;
          case 5:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 1, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -1, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -3, i)));
            break;
          case 6:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -1, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 3, i)));
            break;
          case 7:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 1, i)));
            break;
          case 8:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -1, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, 1, i)));
            break;
          case 9:
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -3, i)));
            solutions.add(String.valueOf(generateSolution(currentSolution, length, -1, i)));
            break;
        }
      }
    }
    return new ArrayList<>(solutions);
  }

  public static int generateSolution(int currentSolution, int length, int dimension, int position) {
    return currentSolution + ((int) (dimension * Math.pow(10, length - position)));
  }
}
