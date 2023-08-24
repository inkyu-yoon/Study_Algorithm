package LeetCode150.주차1.BestTimeToBuyAndSellStock2;

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int sell = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > sell) {
                sell = prices[i];
            } else {
                profit += sell - buy;
                buy = prices[i];
                sell = buy;
            }
        }

        if (buy != sell) {
            profit += sell - buy;
        }


        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }
}