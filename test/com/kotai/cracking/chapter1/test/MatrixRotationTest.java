package com.kotai.cracking.chapter1.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter1.MatrixRotation;

public class MatrixRotationTest {

  private MatrixRotation matrixRotation = new MatrixRotation();

  @Test
  public void transforming_arrays_into_matrices() {
    assertThat(matrixRotation.convertArrayToMatrix(new int[] {1, 2, 3, 4}),
        equalTo(new int[][] {{1, 2}, {3, 4}}));
  }

  @Test
  public void test_rotate() {
    assertThat(matrixRotation.rotate(new int[][] {{1, 2}, {3, 4}}),
        equalTo(new int[][] {{3, 1}, {4, 2}}));

    assertThat(matrixRotation.rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
        equalTo(new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}));

    assertThat(
        matrixRotation
            .rotate(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}),
        equalTo(new int[][] {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}}));
  }
}
