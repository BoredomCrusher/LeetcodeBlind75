package String;

import java.util.HashMap;

public class LargestSubstringWithoutCharacters {
    public static void main(String[] args) {
        LargestSubstringWithoutCharacters largestString = new LargestSubstringWithoutCharacters();
        String testString = "dvdf";

        System.out.println("largest substring: " + largestString.lengthOfLongestSubstring(testString));
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
                tempString = "";
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
