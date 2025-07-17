package String;

public class PalindromicSubstrings {
    // Leetcode 647

    public static void main(String[] args) {
        String[] inputs = new String[] {"a", "aa", "abc", "aaa", "aaaa", "abccba", 
                                        "abcacba", "abcabc", "aaaaa", "aaaaaa",
                                         "aabbccccbbaa"};
        int[] answers = new int[] {1, 3, 3, 6, 10, 10, 10, 6, 15, 21, 26};

        for (int i = 0; i < inputs.length; i++) {
            tests(i, inputs[i], answers[i]);
        }
    }

    public static void tests(int testNum, String input, int realAnswer) {
        int testAnswer = countSubstrings(input);
        System.out.printf("test %d: expected %d and actual %d, %b\n", 
                        testNum + 1, realAnswer, testAnswer, 
                        realAnswer == testAnswer);
    }

     public static int countSubstrings(String s) {
        int output = 0;

        for (int i = 0; i < s.length(); i++) {
            output += count_palindrome(s, i, i);
            output += count_palindrome(s, i, i + 1);
        }

        return output;        
    }

    private static int count_palindrome(String s, int left, int right) {
        int output = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            output++;
            left--;
            right++;
        }
        return output;
    }

    // public static int countSubstrings(String s) {
    //     System.out.println("string: " + s);
    //     if (s.length() == 0) {
    //         return 0;
    //     }
    //     int output = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         output += countAllSameLetters(i, s, true);
    //         output += countAllMirroredStrings(i, s);
    //     }
    //     System.out.println("output without single-character palindromes: " + output);
    //     return output += s.length();
    // }

    // public static int countAllSameLetters(int index, String s) {
    //     if (index >= s.length()) {
    //         return 0;
    //     }
    //     int left = index - 1;
    //     int output = 0;

    //     if (left >= 0 && s.charAt(left) == s.charAt(index)) {
    //         System.out.println("same: " + s.charAt(left) + s.charAt(index) + " index " + index);
    //         return 1;
    //     }


    //     return output;
    // }

    // public static int countAllMirroredStrings(int index, String s) {
    //     if (index - 1 < 0 )
    //         return 0;

    //     int output = 0;
    //     int left = s.length() % 2 == 1 ? index - 1 : index;
    //     int right = index + 1;

    //     while (left >= 0 && right < s.length()) {
    //         if (s.charAt(left) == s.charAt(right)) {
    //             System.out.println("mirrored: " + s.substring(left, right + 1) + " index: " + index);
    //             output++;
    //             left--;
    //             right++;
    //         } else {
    //             return output;
    //         }

    //     }

    //     return output;
    // }
}