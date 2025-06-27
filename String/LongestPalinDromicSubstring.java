package String;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestPalinDromicSubstring {
    // Leetcode 5
    public static void main(String[] args) {
        String test0 = "babad";
        String test1 = "abccba";
        String test2 = "abcacba";
        String test3 = "aaaa";
        String test4 = "aabaa";
        String test5 = "abcdefg";
        String test6 = "abba";
        String test7 = "ababa";

        System.out.println("test0, bab or aba: " + longestPalindrome(test0) + "\n");
        System.out.println("test1, abccba: " + longestPalindrome(test1) + "\n");
        System.out.println("test2, abcacba: " + longestPalindrome(test2) + "\n");
        System.out.println("test3, aaaa: " + longestPalindrome(test3) + "\n");
        System.out.println("test4, aabaa: " + longestPalindrome(test4) + "\n");
        System.out.println("test5, a: " + longestPalindrome(test5) + "\n");
        System.out.println("test6, abba: " + longestPalindrome(test6) + "\n");
        System.out.println("test7, ababa: " + longestPalindrome(test7) + "\n");
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
