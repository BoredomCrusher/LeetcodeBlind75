package Interval;

import java.util.LinkedList;
import java.util.Queue;

// LeetCode Problem 57
public class InsertInterval {
    public static void main(String[] args) {
        int[][] input1 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[][] input2 = { { 1, 3 }, { 6, 9 } };
        int[][] input3 = { { 1, 5 } };

        int[][] output1 = insert(input1, new int[] { 4, 8 });
        int[][] output2 = insert(input2, new int[] { 2, 5 });
        int[][] output3 = insert(input3, new int[] { 2, 3 });

        for (int i = 0; i < output1.length; i++) 
            System.out.print("[" + output1[i][0] + ", " + output1[i][1] + "] ");
        
        System.out.println();
        for (int i = 0; i < output2.length; i++) 
            System.out.print("[" + output2[i][0] + ", " + output2[i][1] + "] ");
        
        System.out.println();
        for (int i = 0; i < output3.length; i++) 
            System.out.println("[" + output3[i][0] + ", " + output3[i][1] + "] ");
        
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) 
            return new int[][] { newInterval };
        

        Queue<int[]> intervalQueue = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {
            // If end of newInterval is less than the start value of the current interval,
            // there are no more possible overlaps.
            if (newInterval[1] < intervals[i][0]) {
                intervalQueue.add(newInterval);
                while (i < intervals.length) {
                    intervalQueue.add(intervals[i]);
                    i += 1;
                }
                break;
            }

            // If the start of newInterval is greater than the end of the current interval,
            // there is no overlap between the two intervals.
            if (newInterval[0] > intervals[i][1]) {
                intervalQueue.add(intervals[i]);
            } else {
                // Checks for overlapping start intervals
                if (newInterval[0] >= intervals[i][0] && intervals[i][1] >= newInterval[0]) 
                    newInterval[0] = intervals[i][0];
                

                // Checks for overlapping end intervals
                if (newInterval[1] >= intervals[i][0] && intervals[i][1] >= newInterval[1]) 
                    newInterval[1] = intervals[i][1];
                
            }

            // Deals with an off by one error if intervals[i] is the only interval in the
            // array.
            if (i == intervals.length - 1) 
                intervalQueue.add(newInterval);
        }

        // Adding the correct intervals to a new array the size of the answer queue
        // because primitive arrays in java are static.
        int[][] answer = new int[intervalQueue.size()][2];
        for (int i = 0; intervalQueue.peek() != null; i++) 
            answer[i] = intervalQueue.poll();
        

        return answer;
    }
}
