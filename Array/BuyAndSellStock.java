package Array;

public class BuyAndSellStock {
    public static void main(String[] args) {
        BuyAndSellStock buyAndSell = new BuyAndSellStock();

        int[] testCase = { 4, 7, 1, 2, 11 };

        System.out.println("the answer for the testcase is: " + buyAndSell.maxProfit(testCase));
    }

    public int maxProfit(int[] prices) {
        int tempMinPrice = prices[0];
        // index zero is the min price, index one is the max price
        int[] minMaxPrice = { tempMinPrice, 0 };

        for (int i = 1; i < prices.length; i++) {
            // sets max price
            if (prices[i] > minMaxPrice[1])
                minMaxPrice[1] = prices[i];

            // resets min price only if the profit is greater than the last min price
            // if so, set max price as well
            if (prices[i] - tempMinPrice > minMaxPrice[1] - minMaxPrice[0]) {
                minMaxPrice[0] = tempMinPrice;
                minMaxPrice[1] = prices[i];
            }

            // sets potential min price
            // -- this is purposefully the last if statement in the loop
            // -- so that the program doesn't set a min price
            // -- if there isn't a max price after it
            if (prices[i] < tempMinPrice)
                tempMinPrice = prices[i];
        }

        int profit = minMaxPrice[1] - minMaxPrice[0];
        return profit > 0 ? profit : 0;
    }
}
