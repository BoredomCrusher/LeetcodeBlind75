
package String;

import java.util.HashMap;

// Code is written to solve leetcode problem 3,
// "Longest Substring Without Repeating Characters."
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
        HashMap<Character, Boolean> map = new HashMap<>();
        String tempString = "";
        String[] splitString = new String[2];
        int finalStringLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // If the next character has already been added to the hashmap.
            if (map.get(s.charAt(i)) != null) {
                // Get the string after the first instance of a repeated character.
                splitString = tempString.split("" + s.charAt(i), 2);
                tempString = splitString[1];

                // Remove the repeated character from hashmap,
                // as well as all the characters before it.
                for (int j = 0; j < splitString[0].length(); j++) {
                    map.remove(splitString[0].charAt(j));
                }
            }

            map.put(s.charAt(i), true);

            // Add the current character to current largest substring without repeats.
            tempString += s.charAt(i);

            // Update the answer.
            if (tempString.length() > finalStringLength) {
                finalStringLength = tempString.length();
            }
        }
        return finalStringLength;
    }
}
