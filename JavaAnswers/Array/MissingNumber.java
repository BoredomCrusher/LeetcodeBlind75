package Array;

import java.util.HashSet;
import java.util.Arrays;
public class MissingNumber {
    public static void main(String[] args) {
        int[][] input = {{0,5,7,6,8,2,9,1,4}, {3, 0, 1}, {0,1}};
        int[] answers = {3,2,2};

        for (int i = 0; i < input.length; i++) {
            System.out.println("Test #" + i + ": " + Arrays.toString(input[i]) + ", answer: " + answers[i]);
            System.out.println("Slow: " + missingNumberSlow(input[i]));
            System.out.println("Fast " + missingNumberFast(input[i]));
        }
    }

    public static int missingNumberSlow(int[] nums) {
        HashSet<Integer> range = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            range.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            range.remove(nums[i]);
        }

        for (Integer element : range) {
            return element;
        }

        // edge case, should never happen
        return -1;
    }

    public static int missingNumberFast(int[] nums){
        int total = 0;
        int inputTotal = 0;
        for (int i = 0; i <= nums.length; i++) {
            total += i;
        }

        for (int i = 0; i < nums.length; i++) {
            inputTotal += nums[i];
        }

        return total - inputTotal;
    }
}
