package Binary;

import java.util.Arrays;

// LeetCode 371
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int[][] input = {{8,3}, {6,7}, {20,30}};
        int[] answers = {11, 13, 50};

        for (int i = 0; i < answers.length; i++) {
            System.out.println("\ntest #" + (i + 1) + ": " + Arrays.toString(input[i]));
            System.out.println("getSum: " + (getSum(input[i][0], input[i][1]) == answers[i]));
        }   
    }

    public static int getSum(int a, int b) {
        // If a and b don't share any bits,
        // (a | b) is the same as (a + b).
        if ((a & b) == 0) {
            return a | b;
        } else {
            while (b != 0) {
                // Binary addition carries a one to the left
                // if two equal places are being added together,
                // so this loop simulates carrying a one to the left
                // then adding it back into the total.
                int temp = (a & b) << 1;
                a = a ^ b;
                b = temp;
            }
            return a;
        }
    }
}
