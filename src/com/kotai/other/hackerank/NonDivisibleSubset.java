package com.kotai.other.hackerank;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        final int ZERO = 0;
        final int HALF = k / 2 == 0 ? k % 2 : -1;
        HashMap<Integer, Integer> divisors = new HashMap<>();
        // Write your code here
        List<Integer> remainders = s.stream().map(value -> value % k).collect(Collectors.toList());

        for (int remainder : remainders) {
            if (divisors.containsKey(remainder)) {
                divisors.put(remainder, divisors.get(remainder) + 1);
            } else {
                divisors.put(remainder, 1);
            }
        }

        int solution = 0;
        for (int i = 1; i <= k / 2; i++) {
            if (i == HALF)
                break;
            int thisValue = divisors.containsKey(i) ? divisors.get(i) : 0;
            int thatValue = divisors.containsKey(k - i) ? divisors.get(k - i) : 0;

            solution += Math.max(thisValue, thatValue);
        }
        if (divisors.containsKey(ZERO)) {
            solution++;
        }
        if (divisors.containsKey(HALF)) {
            solution++;
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(3,
                Lists.newArrayList(new Integer(1), new Integer(7), new Integer(2), new Integer(4))));

    }
}