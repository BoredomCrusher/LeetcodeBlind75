package String;

import java.util.HashMap;
import java.lang.Math;

// LeetCode problem 424
public class LargestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LargestRepeatingCharacterReplacement largestSubstring = new LargestRepeatingCharacterReplacement();

        System.out.println("ABAB, k = 2: " + largestSubstring.solution("ABAB", 2));
        System.out.println("AABABBA, k = 1: " + largestSubstring.solution("AABABBA", 1));
    }

    public int solution(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        // int values of uppercase letters are 65 through 91
        int[] jank = new int[91];

        int maxFrequency, left, longestWindow, windowSize;
        maxFrequency = left = longestWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increments value of current character.
            char currentChar = s.charAt(right);
            jank[currentChar]++;

            // maxFrequency keeps track of the character with the most instances.
            // If maxFrequency increasses, we've found a character in the current window
            // that appears more often than in previous windows.
            maxFrequency = Math.max(maxFrequency, jank[currentChar]);

            currentChar = s.charAt(left);
            windowSize = right - left + 1;

            // While the current size of the window
            // minus the highest instances of a character is greater
            // than the number of letters we can replace,
            // shift the start of the window to the right
            // while deincrementing the instances
            // of the characters we encounter while shifting.
            while (windowSize - maxFrequency > k) {
                jank[currentChar]--;
                currentChar = s.charAt(left++);
                windowSize = right - left + 1;
            }

            // Update the answer.
            longestWindow = Math.max(windowSize, longestWindow);
        }

        return longestWindow;
    }
}