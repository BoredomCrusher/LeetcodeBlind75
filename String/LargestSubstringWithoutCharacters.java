
package String;

import java.util.HashSet;

// LeetCode problem 3: "Longest Substring Without Repeating Characters."
public class LargestSubstringWithoutCharacters {
    public static void main(String[] args) {
        LargestSubstringWithoutCharacters largestString = new LargestSubstringWithoutCharacters();

        Boolean testCase1 = largestString.lengthOfLongestSubstring("abcabcbb") == 3;
        Boolean testCase2 = largestString.lengthOfLongestSubstring("bbbbb") == 1;
        Boolean testCase3 = largestString.lengthOfLongestSubstring("pwwkew") == 3;
        Boolean testCase4 = largestString.lengthOfLongestSubstringSlidingWindow("dvdf") == 3;
        Boolean testCase5 = largestString.lengthOfLongestSubstringSlidingWindow("abba") == 2;
        Boolean testCase6 = largestString.lengthOfLongestSubstringSlidingWindow("abc") == 3;

        System.out.println("testCase1: " + testCase1);
        System.out.println("testCase2: " + testCase2);
        System.out.println("testCase3: " + testCase3);
        System.out.println("testCase4: " + testCase4);
        System.out.println("testCase5: " + testCase5);
        System.out.println("testCase6: " + testCase6);
    }

    public int lengthOfLongestSubstring(String s) {
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

    public int lengthOfLongestSubstringSlidingWindow(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    
}
