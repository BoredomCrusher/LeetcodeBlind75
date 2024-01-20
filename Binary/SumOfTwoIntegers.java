package Binary;

// LeetCode 371
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(8, 3) == 11);
        System.out.println(getSum(6, 7) == 13);
        System.out.println(getSum(20, 30) == 50);
    }

    public static int getSum(int a, int b) {
        // If a and b don't share any bits,
        // (a | b) is the same as (a + b).
        if ((a & b) == 0) {
            return a | b;
        } else {
            while (b != 0) {
                // Binary addition carries a one to the left
                // if two equal places are being added together,
                // so this loop simulates carrying a one to the left
                // then adding it back into the total.
                int temp = (a & b) << 1;
                a = a ^ b;
                b = temp;
            }
            return a;
        }
    }
}
