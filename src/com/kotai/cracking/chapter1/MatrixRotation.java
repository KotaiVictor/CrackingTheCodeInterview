package com.kotai.cracking.chapter1;

public class MatrixRotation {

  public int[][] rotate(int[][] matrix) {
    validateMatrix(matrix);

    int length = matrix.length - 1;
    int numberOfPasses = matrix.length / 2;

    for (int pass = 0; pass < numberOfPasses; pass++) {
      for (int i = pass; i < length - pass; i++) {
        int temp = matrix[pass][i];
        matrix[pass][i] = matrix[length - i][pass];
        matrix[length - i][pass] = matrix[length - pass][length - i];
        matrix[length - pass][length - i] = matrix[i][length - pass];
        matrix[i][length - pass] = temp;
      }
    }

    printMatrix(matrix);
    return matrix;
  }

  private void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  private void validateMatrix(int[][] matrix) {
    int size = matrix.length;
    for (int index = 0; index < size; index++)
      if (size != matrix[index].length)
        throw new IllegalArgumentException();
  }

  public int[][] convertArrayToMatrix(int[] array) {
    int matrixLength = (int) Math.sqrt(array.length);
    int[][] matrix = new int[matrixLength][matrixLength];
    for (int i = 0; i < matrixLength; i++)
      for (int j = 0; j < matrixLength; j++)
        matrix[i][j] = array[i * matrixLength + j];

    return matrix;
  }
}
