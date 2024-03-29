
package String;

import java.util.HashSet;

// LeetCode problem 3: "Longest Substring Without Repeating Characters."
public class LargestSubstringWithoutCharacters {
    public static void main(String[] args) {
        LargestSubstringWithoutCharacters largestString = new LargestSubstringWithoutCharacters();

        Boolean testCase1 = largestString.lengthOfLongestSubstring("abcabcbb") == 3;
        Boolean testCase2 = largestString.lengthOfLongestSubstring("bbbbb") == 1;
        Boolean testCase3 = largestString.lengthOfLongestSubstring("pwwkew") == 3;
        Boolean testCase4 = largestString.lengthOfLongestSubstring("dvdf") == 3;
        Boolean testCase5 = largestString.lengthOfLongestSubstring("abba") == 2;
        Boolean testCase6 = largestString.lengthOfLongestSubstring("abc") == 3;

        System.out.println("testCase1: " + testCase1);
        System.out.println("testCase2: " + testCase2);
        System.out.println("testCase3: " + testCase3);
        System.out.println("testCase4: " + testCase4);
        System.out.println("testCase5: " + testCase5);
        System.out.println("testCase6: " + testCase6);
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        String currentSubstring = "";
        int LongestStringLength = 0;

        for (char c : s.toCharArray()) {
            // Checks if the next character has already been added to the hashset.
            if (set.contains(c)) {
                // Gets the string after the first instance of a repeated character.
                String[] splitString = currentSubstring.split("" + c, 2);
                currentSubstring = splitString[1];

                // Removes the repeated character from hashset,
                // as well as all the characters before it.
                for (char ch : splitString[0].toCharArray()) {
                    set.remove(ch);
                }
            }

            set.add(c);

            // Adds the current character to current largest substring without repeats.
            currentSubstring += c;

            // Updates the answer.
            if (currentSubstring.length() > LongestStringLength) {
                LongestStringLength = currentSubstring.length();
            }
        }
        return LongestStringLength;
    }
}
