
package String;

import java.util.Arrays;
import java.util.HashSet;

// LeetCode Problem 3
public class LargestSubstringWithoutCharacters {
    public static void main(String[] args) {
        String[] tests = new String[] {"abcabcbb", "bbbbb", "pwwkew", "dvdf", "abba", "abc"};
        int[] answers = new int[] {3, 1, 3, 3, 2, 3};

        for (int i = 0; i < answers.length; i++) {
            System.out.println("\ntest #" + (i + 1) + ": " + tests[i]);
            System.out.println("bruteForce: " + (bruteForce(tests[i]) == answers[i]));
            System.out.println("withSlidingWindow: " + (withSlidingWindow(tests[i]) == answers[i]));
        }
    }

    public static int bruteForce(String s) {
        String currentSubstring = "";
        int maxLength = 0;
        int index;
        for (char c : s.toCharArray()) {
            index = currentSubstring.indexOf(c);
            if (index != -1)
                currentSubstring = currentSubstring.substring(index + 1);

            currentSubstring += c;
            maxLength = Math.max(maxLength, currentSubstring.length());
        }

        return maxLength;
    }

    public static int withSlidingWindow(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    
}
