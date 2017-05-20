package com.kotai.other;

/**
 * Created by victorkotai on 11/05/2017.
 */
public class SudokuSolver {

    public static void solveSudoku(int[][] input) {
        if (solve(0, 0, input)) {
            printSudoku(input);
        }
    }

    public static boolean solve(int row, int column, int[][] matrix) {
        if (row == 9) {
            row = 0;
            column ++;
            if (column == 9) {
                return true;
            }
        }

        if (matrix[row][column] != 0) {
            solve(row + 1, column, matrix);
        }

        for (int val = 1; val <= 9; val++) {
            if (isPositionValid(row, column, val, matrix)) {
                matrix[row][column] = val;
                if (solve(row+1, column, matrix)) {
                    return true;
                }
            }
        }
        matrix[row][column] = 0;
        return false;
    }

    public static boolean isPositionValid(int row, int column, int value, int[][] matrix) {
        return isRowValid(row, value, matrix) && isColumnValid(column, value, matrix) && isBoxValid(row, column, value, matrix);
    }

    public static boolean isRowValid(int row, int value, int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            if (value == matrix[row][i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isColumnValid(int column, int value, int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            if (value == matrix[i][column]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isBoxValid(int rowPosition, int columnPosition, int value, int[][] matrix) {
        int boxRowOffset = (rowPosition / 3) * 3;
        int columnOffset = (columnPosition / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (value == matrix[boxRowOffset + i][columnOffset + j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSudoku(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] == 0 ? " " : matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
