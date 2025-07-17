import java.util.HashMap;

// LeetCode problem 70
public class ClimbingStairs {
    HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        for (int i = 1; i < 46; i++) {
            System.out.println("test #" + i + ": " + climbingStairs.climbStairs(i));
        }
    }

    public int climbStairs(int n) {
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        return recursiveSolution(n);
    }

    public int recursiveSolution(int n) {
        if (map.get(n) == null) {
            map.put(n, recursiveSolution(n - 1) + recursiveSolution(n - 2));
        }

        return map.get(n);
    }
}
