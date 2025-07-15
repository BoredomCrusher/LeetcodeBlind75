package Array;

import java.util.HashMap;
import java.util.Arrays;

// LeetCode problem 1
public class TwoSum {
    public static void main(String[] args) {
        int nums[][] = {{ 3, 2, 4 }, {1, 2, 3, 4, 5}, {4, 5, 6, 7}};
        int target[] = { 6, 4, 9 };

        TwoSum twosum = new TwoSum();

        for (int i = 0; i < target.length; i++) {
            System.out.println("\ntest #" + i + " " + Arrays.toString(nums[i]) + " target: " + target[i]);
            System.out.println("twoSum: " + Arrays.toString(twosum.twoSum(nums[i], target[i])));
        }
    }

    // returns the indecies of the two numbers that add up to the target val
    public int[] twoSum(int[] nums, int target) {
        int output[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                output[0] = map.get(nums[i]);
                output[1] = i;
                return output;
            }
            map.put(target - nums[i], i);
        }
        // this return should only happen if there is no solution
        return output;
    }
}
