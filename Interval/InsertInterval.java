package Interval;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
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
            }

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
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
