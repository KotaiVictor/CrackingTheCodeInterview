package com.kotai.cracking.chapter1.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter1.MatrixZeroFill;

public class MatrixZeroFillTest {

  private MatrixZeroFill zeroFiller = new MatrixZeroFill();

  @Test
  public void two_d_matrix_case() {
    assertThat(zeroFiller.zeroifyMatrix(new int[][] {{1, 1}, {0, 1}}),
        equalTo(new int[][] {{0, 1}, {0, 0}}));
    assertThat(zeroFiller.zeroifyMatrix(new int[][] {{0, 0}, {10, 10}}),
        equalTo(new int[][] {{0, 0}, {0, 0}}));
  }

  @Test
  public void two_by_three_matrix_case() {
    assertThat(zeroFiller.zeroifyMatrix(new int[][] {{1, 1, 1}, {0, 1, 0}}),
        equalTo(new int[][] {{0, 1, 0}, {0, 0, 0}}));
  }

  @Test
  public void three_row_matrix_with_the_second_row_smaller_case() {
    assertThat(zeroFiller.zeroifyMatrix(new int[][] {{1, 1, 1}, {1, 0}, {1, 1, 0}}),
        equalTo(new int[][] {{1, 0, 0}, {0, 0}, {0, 0, 0}}));
  }

  @Test
  public void two_d_matrix_case_alg2() {
    assertThat(zeroFiller.zeroifyMatrix2(new int[][] {{1, 1}, {0, 1}}),
        equalTo(new int[][] {{0, 1}, {0, 0}}));
    assertThat(zeroFiller.zeroifyMatrix2(new int[][] {{0, 0}, {10, 10}}),
        equalTo(new int[][] {{0, 0}, {0, 0}}));
  }

  @Test
  public void two_by_three_matrix_case_alg2() {
    assertThat(zeroFiller.zeroifyMatrix2(new int[][] {{1, 1, 1}, {0, 1, 0}}),
        equalTo(new int[][] {{0, 1, 0}, {0, 0, 0}}));
  }

  @Test
  public void three_row_matrix_with_the_second_row_smaller_case_alg2() {
    assertThat(zeroFiller.zeroifyMatrix2(new int[][] {{1, 1, 1}, {1, 0}, {1, 1, 0}}),
        equalTo(new int[][] {{1, 0, 0}, {0, 0}, {0, 0, 0}}));
  }
}
