package com.kotai.cracking.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, fill its row and its column with zeroes
 */
public class MatrixZeroFill {

  public int[][] zeroifyMatrix(int[][] inputMatrix) {
    int[][] returnMatrix = copyMatrix(inputMatrix);

    for (int row = 0; row < inputMatrix.length; row++) {
      for (int column = 0; column < inputMatrix[row].length; column++) {
        if (inputMatrix[row][column] == 0) {
          returnMatrix = zeroifyColumn(returnMatrix, column);
          returnMatrix = zeroifyRow(returnMatrix, row);
        }
      }
    }

    return returnMatrix;
  }

  public int[][] zeroifyMatrix2(int[][] inputMatrix) {
    Set<Integer> zeroifiedColumns = new HashSet<>();
    Set<Integer> zeroifiedRows = new HashSet<>();

    for (int row = 0; row < inputMatrix.length; row++)
      for (int column = 0; column < inputMatrix[row].length; column++) {
        if (inputMatrix[row][column] == 0) {
          zeroifiedColumns.add(column);
          zeroifiedRows.add(row);
        }
      }

    for (Integer row : zeroifiedRows)
      inputMatrix = zeroifyRow(inputMatrix, row);

    for (Integer column : zeroifiedColumns)
      inputMatrix = zeroifyColumn(inputMatrix, column);

    return inputMatrix;
  }

  private int[][] copyMatrix(int[][] inputMatrix) {
    int[][] returnMatrix = new int[inputMatrix.length][];
    for (int index = 0; index < inputMatrix.length; index++)
      returnMatrix[index] = inputMatrix[index].clone();
    return returnMatrix;
  }

  private int[][] zeroifyRow(int[][] matrix, int row) {
    for (int column = 0; column < matrix[row].length; column++)
      matrix[row][column] = 0;
    return matrix;
  }

  private int[][] zeroifyColumn(int[][] matrix, int column) {
    for (int row = 0; row < matrix.length; row++)
      if (matrix[row].length > column)
        matrix[row][column] = 0;
    return matrix;
  }
}
