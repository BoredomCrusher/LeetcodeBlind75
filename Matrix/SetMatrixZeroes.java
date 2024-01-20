package Matrix;

import java.util.ArrayList;
import java.util.HashMap;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer, ArrayList<Integer>> newZeroes = new HashMap<>();

        // These double nested for loops iterate through the matrix.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Checks if the current location is a zero
                // that existed in the original matrix.
                if (matrix[i][j] == 0 && (newZeroes.get(i) != null && !newZeroes.get(i).contains(j))) {
                    // Fills current row with zeroes
                    matrix = fillZeroes(matrix, newZeroes, i, j);
                    System.out.println("zero, row " + i + " column " + j);
                }
            }
        }
    }

    public int[][] fillZeroes(int[][] matrix, HashMap<Integer, ArrayList<Integer>> newZeroes, int initialRow,
            int initialColumn) {
        for (int fillRow = 0; fillRow < matrix.length; fillRow++) {
            if (matrix[fillRow][initialColumn] != 0) {
                matrix[fillRow][initialColumn] = 0;
                if (newZeroes.get(fillRow) == null) {
                    newZeroes.put(fillRow, new ArrayList<Integer>());
                    newZeroes.get(fillRow).add(initialColumn);
                } else {
                    newZeroes.get(fillRow).add(initialColumn);
                }
            }
        }

        // Fills current column with zeroes
        for (int fillColumn = 0; fillColumn < matrix[0].length; fillColumn++) {
            if (matrix[initialRow][fillColumn] != 0) {
                matrix[initialRow][fillColumn] = 0;
                if (newZeroes.get(initialRow) == null) {
                    newZeroes.put(initialRow, new ArrayList<Integer>());
                    newZeroes.get(initialRow).add(fillColumn);
                } else {
                    newZeroes.get(initialRow).add(fillColumn);
                }
            }
        }

        return matrix;
    }
}
