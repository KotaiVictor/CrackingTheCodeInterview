package com.kotai.cracking.chapter5;

/*
 * You are given two 32-bit numbers, N and M, and two bit positions, land j. Write a method to
 * insert M into N such that M starts at bit j and ends at bit i. You can assume that the bits j
 * through i have enough space to fit all of M. That is, if M = 10011, you can assume that there are
 * at least 5 bits between j and i. You would not, for example, have j = 3 and i = 2, because M
 * could not fully fit between bit 3 and bit 2. EXAMPLE Input: N = 10000000000, M = 10011, i = 2, j
 * = 6 Output: N = 10001001100
 */
public class NumberMixer {

  public Object insertNumbers(int numberToInsertInto, int insertedNumber, int startingAt,
      int endingAt) {
    assert((startingAt < endingAt) && startingAt >= 0);
    // create a mask that clears the bits startingAt through endingAt in numberToInsertInto
    int allOnes = ~0;
    int left = allOnes << (endingAt + 1); // 11110000000
    int right = (1 << startingAt) - 1; // 0000000011111

    int mask = left | right;
    int toInsertInto_cleared = numberToInsertInto & mask;
    int toInsert_shifted = insertedNumber << startingAt;

    return toInsertInto_cleared | toInsert_shifted;
  }

}
