package com.kotai.cracking.chapter1;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
 * method to rotate the image by 90 degrees. Can you do this in place?
 */

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

    return matrix;
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
