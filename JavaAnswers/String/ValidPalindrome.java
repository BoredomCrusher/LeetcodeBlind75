package String;

public class ValidPalindrome {
    // Leetcode Problem 125

    // Brute force
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String allLetters = "abcdefghijklmnopqrstuvwxyz0123456789";

        int right = s.length() - 1;
        for (int left = 0; left <= right; left++) {
            if (allLetters.contains(String.valueOf(s.charAt(left)))) {
                
                while (!allLetters.contains(String.valueOf(s.charAt(right))) && left < right) {
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
