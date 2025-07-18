package String;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestPalinDromicSubstring {
    // Leetcode Problem 5
    public static void main(String[] args) {
        String[] tests = {"babad", "abccba", "abcacba", "aaaa", 
                            "aabaa", "abcdefg", "abba", "ababa"};
        String[] answers = {"bab or aba", "abccba", "abcacba", "aaaa", "aabaa", "a", "abba", "ababa"};

        for (int i = 0; i < tests.length; i++) {
            System.out.println("test #" + (i + 1) + ", " + answers[i] + ": " + longestPalindrome(tests[i]));
        }
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0)
            return s;

        String output = "" + s.charAt(0);

        // char, indexes
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ArrayList<Integer> currentList = map.get(s.charAt(i));
                for (int j = 0; j < currentList.size(); j++) {
                    int currentIndex = currentList.get(j);
                    if (i - currentIndex >= output.length()) {
                        output = checkForReverse(s, output, currentIndex, i);    
                    }
                }
            } else {
                map.put(s.charAt(i), new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        return output;
    }

    public static String checkForReverse(String s, String output, int previousIndex, int currentIndex) {
        int left = previousIndex;
        int right = currentIndex;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return output;
        }
        return s.substring(previousIndex, currentIndex + 1);
    }
}
