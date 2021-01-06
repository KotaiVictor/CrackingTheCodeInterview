package com.kotai.other.hackerank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Both players are given the same string, .
Both players have to make substrings using the letters of the string .
Stuart has to make words starting with consonants.
Kevin has to make words starting with vowels.
The game ends when both players have made all possible substrings.
*/
public class MinionGame {

    public static Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String playGame(String input) {
        int stuart = 0;
        int kevin = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (vowels.contains(c)) {
                kevin += input.length() - i;
            } else {
                stuart += input.length() - i;
            }
        }
        if (kevin > stuart) {
            return "Kevin " + kevin;
        } else if (stuart > kevin) {
            return "Stuart " + stuart;
        } else {
            return "Draw " + stuart;
        }
    }

    public static void main(String[] args) {
        System.out.println(playGame("BANANA"));
    }
}
