package String;

import java.util.HashMap;

// code is written to solve leetcode problem 3
public class LargestSubstringWithoutCharacters {
    public static void main(String[] args) {
        LargestSubstringWithoutCharacters largestString = new LargestSubstringWithoutCharacters();

        Boolean testCase1 = largestString.lengthOfLongestSubstring("abcabcbb") == 3;
        Boolean testCase2 = largestString.lengthOfLongestSubstring("bbbbb") == 1;
        Boolean testCase3 = largestString.lengthOfLongestSubstring("pwwkew") == 3;
        Boolean testCase4 = largestString.lengthOfLongestSubstring("dvdf") == 3;
        Boolean testCase5 = largestString.lengthOfLongestSubstring("abba") == 2;

        System.out.println("testCase1: " + testCase1);
        System.out.println("testCase2: " + testCase2);
        System.out.println("testCase3: " + testCase3);
        System.out.println("testCase4: " + testCase4);
        System.out.println("testCase4: " + testCase5);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        HashMap<Character, Boolean> map = new HashMap<>();
        String tempString = "";
        int finalStringLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // if next character has already been added to the hashmap
            if (map.get(s.charAt(i)) != null) {
                // get string after first instance of repeated character
                tempString = tempString.split("" + s.charAt(i), 2)[1];

                // reset hashmap and fill with characters of current string
                // -- I have no idea why just removing the current character doesn't work
                // -- but somehow, that doesn't work, and this works
                // -- for every testcase on leetcode
                map = new HashMap<>();
                for (int j = 0; j < tempString.length(); j++) {
                    map.put(tempString.charAt(j), true);
                }
            }

            // add current character to hashmap
            map.put(s.charAt(i), true);

            // add current character to current largest substring without repeats
            tempString += s.charAt(i);

            // update answer
            if (tempString.length() > finalStringLength) {
                finalStringLength = tempString.length();
            }
        }
        return finalStringLength;
    }
}
