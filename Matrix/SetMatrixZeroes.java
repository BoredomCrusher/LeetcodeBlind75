package Matrix;

import java.util.ArrayList;
import java.util.HashMap;

// LeetCode 73
public class SetMatrixZeroes {
     public void setZeroes(int[][] matrix) {
        boolean zeroInInitialColumn = false;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0)
                zeroInInitialColumn = true;
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                       matrix[row][0] = 0;
                       matrix[0][column] = 0;
                }
                 
            }
        }
        
        // Needs to traverse backwards to not accidentally overwrite things,
        // for strange reasons.
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int column = matrix[0].length - 1; column >= 1; column--) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) 
                    matrix[row][column] = 0;
            }
            
            if (zeroInInitialColumn)
                 matrix[row][0] = 0;
        }
    }


    public void setZeroesBruteForce(int[][] matrix) {
        HashMap<Integer, ArrayList<Integer>> newZeroes = new HashMap<>();

        // Fills the HashMap with an ArrayList for every row,
        // this is the same runtime as checking if HashMap.get(row) == null
        // while iterating through the matrix.
        for (int i = 0; i < matrix.length; i++) {
            newZeroes.put(i, new ArrayList<Integer>());
        }

        // Double nested for loops iterating through the matrix.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Checks if the current location is a zero
                // that existed in the original matrix.
                if (matrix[i][j] == 0 && !newZeroes.get(i).contains(j)) {
                    // Fills the current and column row with zeroes.
                    fillZeroesBruteForce(matrix, newZeroes, i, j);
                }
            }
        }
    }

    public void fillZeroesBruteForce(int[][] matrix, HashMap<Integer, ArrayList<Integer>> newZeroes, int initialRow,
            int initialColumn) {
        // Fills current row with zeroes.
        for (int fillRow = 0; fillRow < matrix.length; fillRow++) {
            // Avoids adding an original zero to the newZeroes HashMap.
            if (matrix[fillRow][initialColumn] != 0) {
                matrix[fillRow][initialColumn] = 0;
                newZeroes.get(fillRow).add(initialColumn);
            }
        }

        // Fills current column with zeroes.
        for (int fillColumn = 0; fillColumn < matrix[0].length; fillColumn++) {
            if (matrix[initialRow][fillColumn] != 0) {
                matrix[initialRow][fillColumn] = 0;
                newZeroes.get(initialRow).add(fillColumn);
            }
        }
    }
}
