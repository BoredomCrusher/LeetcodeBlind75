package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// LeetCode 207
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] input1 = { { 0, 2 }, { 1, 2 }, { 2, 0 } };
        int numCourses1 = 3;

        int[][] input2 = { { 1, 0 }, { 0, 2 }, { 2, 1 } };
        int numCourses2 = 3;

        int[][] input3 = { { 1, 0 }, { 2, 3 }, { 2, 4 } };
        int numCourses3 = 5;

        System.out.println(canFinish(numCourses1, input1) == false);
        System.out.println(canFinish(numCourses2, input2) == false);
        System.out.println(canFinish(numCourses3, input3) == true);

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }

        if (prerequisites.length == 0 || numCourses == 1) {
            return true;
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        // Fill map with all courses (first value) and their prerequisites (second
        // value).
        // Courses can have multiple prerequisites, so there can be multiple values for
        // one key,
        // so each key has a value of an arraylist with all of the matching integer
        // values.
        for (int[] courses : prerequisites) {
            if (map.get(courses[0]) == null) {
                map.put(courses[0], new ArrayList<Integer>());
                map.get(courses[0]).add(courses[1]);
            } else {
                map.get(courses[0]).add(courses[1]);
            }
        }

        // Since every value in prerequisites is between 0 and numCourses,
        // check every value between 0 and numCourses for a cycle.
        for (int i = 0; i < numCourses; i++) {
            if (!(hasNoCycle(map, visited, i))) {
                return false;
            }
        }

        return true;
    }

    // Recursively checks for a cycle of keys and values, returns false if one is
    // found
    public static boolean hasNoCycle(HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited,
            int currentCourse) {
        // 'visited' contains every value previously visited while iterating through the
        // graph,
        // and if the value has alreay been visited, a cycle exists.
        if (visited.contains(currentCourse)) {
            return false;
        }

        // If a key has no more values, the key has no more values to check,
        // and therefore is not part of a cycle.
        if (map.get(currentCourse) == null) {
            return true;
        }

        visited.add(currentCourse);

        // Recursively checks every course (key) for a cycle.
        for (int i : map.get(currentCourse)) {
            if (!(hasNoCycle(map, visited, i))) {
                return false;
            }
        }

        // If the code has reached this point, the current course (key) can be completed
        // since all of its prerequisites (values for the key) can be completed.
        // It no longer needs to be checked for loops as a prerequisite (value) for
        // other courses (keys),
        // and visiting it once more does not mean a loop exists.
        visited.remove(currentCourse);
        map.remove(currentCourse);

        return true;
    }
}
