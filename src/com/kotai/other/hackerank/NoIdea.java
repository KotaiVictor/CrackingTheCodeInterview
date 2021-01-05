package com.kotai.other.hackerank;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * There is an array of integers. There are also disjoint sets, A and B, each
 * containing integers. You like all the integers in set A and dislike all the
 * integers in set B. Your initial happiness is 0. For each integer in the
 * array, if i in A , you add 1 to your happiness. If i in B, you add -1 to your
 * happiness. Otherwise, your happiness does not change. Output your final
 * happiness at the end.
 */
public class NoIdea {

    public static int calculateHapiness(int[] liked, int[] disliked, int[] input) {
        Set<Integer> likedSet = generateSet(liked);
        Set<Integer> dislikedSet = generateSet(disliked);

        return Arrays.stream(input).map(value -> {
            if (likedSet.contains(value)) {
                return 1;
            } else if (dislikedSet.contains(value)) {
                return -1;
            }
            return 0;
        }).sum();
    }

    public static Set<Integer> generateSet(int[] input) {
        return Arrays.stream(input).boxed().collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println(NoIdea.calculateHapiness(new int[] { 1, 3 }, new int[] { 5, 7 }, new int[] { 1, 5, 3 }));
    }
}
