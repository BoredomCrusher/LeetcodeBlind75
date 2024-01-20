package Matrix;

import java.util.ArrayList;
import java.util.HashMap;

// LeetCode 73
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
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
                    fillZeroes(matrix, newZeroes, i, j);
                }
            }
        }
    }

    public void fillZeroes(int[][] matrix, HashMap<Integer, ArrayList<Integer>> newZeroes, int initialRow,
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
