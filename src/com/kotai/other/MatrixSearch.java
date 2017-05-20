package com.kotai.other;

/**
 * Write an efficient algorithm that searches for a value in a m x n matrix.
 * Matrix has the properties:
 * - integers in each row are sorted in ascending left to right
 * - integers on each column are sorted in ascending top to bot
 */
public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            int element = matrix[row][col];
            if (element == target) {
                return true;
            } else if (target < element) {
                col --;
            } else if (target > element) {
                row ++;
            }
        }
        return false;
    }
}