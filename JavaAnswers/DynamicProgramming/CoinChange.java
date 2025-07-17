import java.util.Arrays;

// LeetCode problem 322
public class CoinChange {
    int dp[];

    public static void main(String[] args) {
        int coins[] = { 11, 23, 29, 37, 48, 13 };

        CoinChange coinChange = new CoinChange();
        int numberOfCoins;
        System.out.println("Coins: " + Arrays.toString(coins) + "\n");

        for (int i = 1; i < 50; i++) {
            numberOfCoins = coinChange.coinChange(coins, i);
            if (numberOfCoins == -1) {
                System.out.println("Test #" + i + ": Number cannot be created with these coins");
            } else {
                System.out.println("Test #" + i + ": Number can be made with a minimum of " + numberOfCoins + " coins");
            }
        }
    }

    public int coinChange(int[] coins, int amount) {

        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = coinCount(coins, amount, amount + 1);
        return (ans != amount + 1) ? ans : -1;
    }

    int coinCount(int[] coins, int amount, int max) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return max;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = max;

        for (int coin : coins) {
            int ans = coinCount(coins, amount - coin, max);

            if (ans != max) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        dp[amount] = minCoins;
        return dp[amount];
    }
}