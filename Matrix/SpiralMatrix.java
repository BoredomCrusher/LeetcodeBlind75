package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4}, {4,5,6,7}, {8,9,10,11}};

        List<Integer> list = new ArrayList<>();

        list = spiralOrder(matrix);

        System.out.print("[ ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.print("], ");
        }
        System.out.print(" ]\n");

        System.out.print("[ ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print("]\n");
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        int left = 0;
        int bot = matrix.length - 1;
        int right = matrix[0].length - 1;
        int top = 0;

        while (top <= bot && left <= right) {
            for (int i = left; i <= right; i++)
                answer.add(matrix[top][i]);

            top++;
            
            for (int i = top; i <= bot; i++)
                answer.add(matrix[i][right]);
            
            right--;

            if (top <= bot) {
                for (int i = right; i >= left; i--)
                answer.add(matrix[bot][i]);
            
                bot--;
            }
            
            if (left <= right) {
            for (int i = bot; i >= top; i--)
                answer.add(matrix[i][left]);

            left++;
            }
            
        }

        return answer;
    }
}
