package com.kotai.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A number is called as a Jumping Number if all adjacent digits in it differ by 1. The difference
 * between ‘9’ and ‘0’ is not considered as 1.All single digit numbers are considered as Jumping
 * Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not. * Given a
 * positive number x, print all Jumping Numbers smaller than or equal to x. The numbers can be
 * printed in any order.
 */
public class JumpingNumbers {

  private static List<Integer> generateJumpingStartingWith(int x, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    List<Integer> results = new ArrayList<>();
    while (!queue.isEmpty()) {
      int number = queue.poll();
      if (number < x) {
        results.add(number);
        int lastDigit = number % 10;
        switch (lastDigit) {
          case 0:
            queue.add((number * 10) + (lastDigit + 1));
            break;
          case 9:
            queue.add((number * 10) + (lastDigit - 1));
            break;
          default:
            queue.add((number * 10) + (lastDigit + 1));
            queue.add((number * 10) + (lastDigit - 1));
            break;
        }
      }
    }
    return results;
  }

  public static List<Integer> generateJumping(int x) {
    List<Integer> results = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      results.addAll(generateJumpingStartingWith(x, i));
    }
    Collections.sort(results);
    return results;
  }

  public static void main(String[] args) {
    List<Integer> solution = generateJumping(100);

    solution.stream().forEach(value -> System.out.print(value + " "));
  }
}
