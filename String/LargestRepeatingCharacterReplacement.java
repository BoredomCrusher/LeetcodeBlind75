package String;

import java.util.HashMap;

public class LargestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LargestRepeatingCharacterReplacement largestSubstring = new LargestRepeatingCharacterReplacement();

        System.out.println("ABAB, k = 2: " + largestSubstring.solution("ABAB", 2));
        System.out.println("AABABBA, k = 1: " + largestSubstring.solution("AABABBA", 1));
    }

    public int solution(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        // Fills hashmap with all uppercase letters,
        // each with a value of zero.
        for (int i = 65; i < 91; i++) {
            char key = (char) i;
            map.put(key, 0);
        }

        int maxFrequency = 0;

        int left = 0;
        int longestWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increments value of current character.
            map.put(s.charAt(right), map.get(s.charAt(right)) + 1);

            // maxFrequency keeps track of the character with the most instances.
            // If maxFrequency increasses, we've found a character in the current window
            // that appears more often than in previous windows.
            if (map.get(s.charAt(right)) > maxFrequency) {
                maxFrequency = map.get(s.charAt(right));
            }

            int windowSize = right - left + 1;

            // While the current size of the window
            // minus the highest instances of a character is greater
            // than the number of letters we can replace,
            // shift the start of the window to the right
            // while deincrementing the instances
            // of the characters we encounter while shifting.
            while (windowSize - maxFrequency > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left += 1;
                windowSize = right - left + 1;
            }

            // Update the answer.
            if (windowSize > longestWindow) {
                longestWindow = windowSize;
            }
        }
        return longestWindow;

    }
}