package Interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// LeetCode problem 56
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] input2 = { { 1, 4 }, { 2, 3 } };
        int[][] input3 = { { 1, 4 }, { 4, 5 } };

        int[][] output1 = merge(input1);
        int[][] output2 = merge(input2);
        int[][] output3 = merge(input3);

        for (int i = 0; i < output1.length; i++) {
            System.out.print("[" + output1[i][0] + ", " + output1[i][1] + "] ");
        }

        System.out.println();
        for (int i = 0; i < output2.length; i++) {
            System.out.print("[" + output2[i][0] + ", " + output2[i][1] + "] ");
        }

        System.out.println();
        for (int i = 0; i < output3.length; i++) {
            System.out.println("[" + output3[i][0] + ", " + output3[i][1] + "] ");
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        // Sorts array based on first dimension.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Queue<int[]> intervalQueue = new LinkedList<>();

        int[] newInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // If the end interval less than the start value of the next interval,
            // it is not overlapping.
            if (newInterval[1] < intervals[i][0]) {
                intervalQueue.add(newInterval);
                newInterval = intervals[i];
            }

            // Checks for overlapping intervals
            if (newInterval[1] >= intervals[i][0] && intervals[i][1] >= newInterval[1]) {
                newInterval[1] = intervals[i][1];
            }

            // Deals with an off by one error if intervals[i] is the last interval in the
            // array.
            if (i == intervals.length - 1) {
                intervalQueue.add(newInterval);
            }
        }

        // Adding the correct intervals to a new array the size of the answer queue
        // because primitive arrays in java are static.
        int[][] answer = new int[intervalQueue.size()][2];
        for (int i = 0; intervalQueue.peek() != null; i++) {
            answer[i] = intervalQueue.poll();
        }

        return answer;

    }
}
