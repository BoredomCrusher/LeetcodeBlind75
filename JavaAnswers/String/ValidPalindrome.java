package String;

import java.util.HashSet;

public class ValidPalindrome {
    // Leetcode Problem 125

    // Brute force
    public boolean isPalindromeHashSet(String s) {
        s = s.toLowerCase();
        String allLetters = "abcdefghijklmnopqrstuvwxyz0123456789";

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < allLetters.length(); i++) {
            set.add(allLetters.charAt(i));
        }

        int right = s.length() - 1;
        for (int left = 0; left <= right; left++) {
            if (set.contains(s.charAt(left))) {
                while (!set.contains(s.charAt(right)) && left < right) {
                    right--;
                } 
                
                if (s.charAt(left) != s.charAt(right)) {
                    System.out.println("" + s.charAt(left) + " " + s.charAt(right));
                    return false; 
                }
                right--;
            }
        }

        return true;
    }
}
