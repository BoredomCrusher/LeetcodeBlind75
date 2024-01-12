package String;

import java.util.HashMap;

public class LargestSubstringWithoutCharacters {
    public static void main(String[] args) {
        LargestSubstringWithoutCharacters largestString = new LargestSubstringWithoutCharacters();

        Boolean testCase1 = largestString.lengthOfLongestSubstring("abcabcbb") == 3;
        Boolean testCase2 = largestString.lengthOfLongestSubstring("bbbbb") == 1;
        Boolean testCase3 = largestString.lengthOfLongestSubstring("pwwkew") == 3;
        Boolean testCase4 = largestString.lengthOfLongestSubstring("dvdf") == 3;

        System.out.println("testCase1: " + testCase1);
        System.out.println("testCase2: " + testCase2);
        System.out.println("testCase3: " + testCase3);
        System.out.println("testCase4: " + testCase4);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        HashMap<Character, Boolean> map = new HashMap<>();
        String tempString = "";
        String finalString = "";

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                // next, remove the string up to the last instance of the repeated character
                // -- currently fails testcase 1
                String[] split = tempString.split("" + s.charAt(i), 2);
                tempString = split[1];
                map = new HashMap<>();
            }

            map.put(s.charAt(i), true);
            tempString += s.charAt(i);

            if (tempString.length() > finalString.length()) {
                finalString = tempString;
            }
        }
        return finalString.length();
    }
}
