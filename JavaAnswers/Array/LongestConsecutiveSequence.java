package Array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Arrays;

public class LongestConsecutiveSequence {
    // Leetcode Problem 128

    public static void main(String[] args) {
        int[][] tests = {{100, 4, 200, 1, 3, 2}, 
                        {0,3,7,2,5,8,4,6,0,1}, 
                        {1,0,1,2}};
        int[] answers = {4, 9, 3};

        for (int i = 0; i < answers.length; i++) {
            System.out.println("\ntest #" + (i + 1) + ": " + Arrays.toString(tests[i]));
            System.out.println("bruteforce: " + (bruteForce(tests[i]) == answers[i]));
            System.out.println("hashMapOnly: " + (hashMapOnly(tests[i]) == answers[i]));
        }
    }

    // Decently fast, O(n)
    public static int hashMapOnly(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        HashSet<Integer> set = new HashSet<>();

        for (int i : nums)
            set.add(i);

        int max = 0;
        int current = 0;

        for (int i : set) {
            if (!set.contains(i - 1)) {
                current = 1;

                while (set.contains(i + current))
                    current++;
                
                max = Math.max(max, current);
            }
        }

        return max;
    }

    // Slow but it works, O(n log n).
    public static int bruteForce(int[] nums) {
         if (nums.length <= 1)
            return nums.length;

        int max, currentMax, currentVal, previousVal;

        max = currentMax = currentVal = 0;
        previousVal = Integer.MIN_VALUE;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (!set.contains(i)) {
                minHeap.add(i);
                set.add(i);
            }
        }

        while (minHeap.peek() != null) {
            currentVal = minHeap.poll();
            if (currentVal == previousVal + 1) {
                currentMax++;
                max = Math.max(max, currentMax);
            } else {
                currentMax = 0;
            }
            
            previousVal = currentVal;
        }

        return max + 1;
    }
}
