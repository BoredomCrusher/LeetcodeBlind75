package Array;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int nums[] = { 3, 2, 4 };
        int target = 6;

        TwoSum twosum = new TwoSum();

        nums = twosum.twoSum(nums, target);

        System.out.println("[" + nums[0] + ", " + nums[1] + "]");
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
