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
            output += countPalindromes(s, i, i);
            output += countPalindromes(s, i, i + 1);
        }

        return output;
    }

    public static int countPalindromes(String s, int left, int right) {
        int output = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            output++;
            left--;
            right++;
        }

        return output;
    }

    // public static int countSubstrings(String s) {
    //     if (s.length() == 0) {
    //         return 0;
    //     }

    //     int output = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         output += countAllSameLetters(i, s);
    //         output += countAllSameLetters(i + 1, s);
    //         output += countAllMirroredStrings(i, s);
    //     }

    //     System.out.println("answer without one-length: " + output + "\n");
    //     // Adds all one-length substrings.
    //     return output += s.length();
    // }

    // public static int countAllSameLetters(int index, String s) {
    //     int left = index - 1;
    //     int output = 0;

    //     if (left >= 0 && s.charAt(left) == s.charAt(index)) {
    //          System.out.println("same: " + s.charAt(left) + s.charAt(left) + " index: " + index);
    //         return 1;
    //     }

    //     return output;
    // }

    // public static int countAllMirroredStrings(int index, String s) {
    //     if (index - 1 < 0 || index + 1 >= s.length()) {
    //         return 0;
    //     }

    //     int output = 0;

    //     boolean isOdd = s.length() % 2 == 1;

    //     // If odd like "cac", left skips over "a" and is is first "c",
    //     // if not odd like "cc", left is first "c".
    //     int left = isOdd ? index - 1 : index;
    //     int right = index + 1;

    //     //System.out.println("" + s.charAt(index) + " left: " 
    //       //                  + s.charAt(left) + " right: " + s.charAt(right));

       

    //     while (left >= 0 && right < s.length()) {
    //         System.out.println("left: " + s.charAt(left) + " right: " + s.charAt(right));
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

    // public static int countAllSameLettersOld(int index, String s) {
    //     int left = index - 1;
    //     int right = index + 1;

    //     int output = 0;

    //     while (left >= 0 && right < s.length()) {
    //         if (s.charAt(left) == s.charAt(index))  {
    //             System.out.println("" + s.charAt(left) + "" + s.charAt(index));
    //             output++;
    //         }

    //         if (s.charAt(right) == s.charAt(index)) {
    //              System.out.println("" + s.charAt(index) + "" + s.charAt(right));
    //             output++;
    //         }
 
    //         if (s.charAt(left) == s.charAt(right) && checkForMirrorPalindrome(left, right, s)) {
    //             System.out.println("yup " + s.charAt(left) + "" + s.charAt(right));
    //             output++;
    //         }
            
    //         left--;
    //         right++;
    //     }
        
    //     return output;
    // }

    // public static boolean checkForMirrorPalindrome(int leftIndex, int rightIndex, String s) {
    //     int left = leftIndex;
    //     int right = rightIndex;
    //     boolean isOdd = ((left - right) % 2 == 1);

    //     if (isOdd) {
    //         while (left <= right) {
    //         if (s.charAt(left) != s.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //         }
    //     } else {
    //         while (left < right) {
    //         if (s.charAt(left) != s.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //         }
    //     }
        

    //     return true;
    // }
}
