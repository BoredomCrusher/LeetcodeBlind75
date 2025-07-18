package Binary;

// LeetCode Problem 191
public class NumberOfOneBits {
    public static void main(String[] args) {
        int input1 = 00000000000000000000000000001011;
        int input2 = 00000000000000000000000010000000;
        // java can't store 11111111111111111111111111111101 as an int by itself,
        // so I bitflipped its inverse to store it in an int
        int input3 = ~00000000000000000000000000000010;

        System.out.println(hammingWeight(input1) == 3);
        System.out.println(hammingWeight(input2) == 1);
        System.out.println(hammingWeight(input3) == 31);
    }

    public static int hammingWeight(int n) {
        if (n == 0)
            return 0;

        int answer = 0;

        if (n > 0) {
            while (n > 0) {
                // Compares the first bit of the input to 1.
                answer += n & 1;
                // Bitshifts right by one to check the next bit.
                n = n >> 1;
            }
            // If the number is negative, bitflip the input to make it
            // positive since signed integers in java use 2's compliment notation.
        } else {
            n = ~n;
            while (n > 0) {
                answer += n & 1;
                n = n >> 1;
            }
            answer = 32 - answer;
        }

        return answer;
    }
}