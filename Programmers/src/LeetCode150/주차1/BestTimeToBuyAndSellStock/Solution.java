package LeetCode150.주차1.BestTimeToBuyAndSellStock;

import java.util.Stack;

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            for (int j = 0; j < i; j++) {
                int buy = prices[j];
                int profit = sell - buy;
                if (profit > 0) {
                    ans = Math.max(ans, profit);
                }
            }
        }

        return ans;
    }

    public int maxProfit2(int[] prices) {
        int ans = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (s.isEmpty()) {
                s.push(price);
            } else {
                while (!s.isEmpty() && s.peek() > price) {
                    s.pop();
                }

                while (s.size() > 1) {
                    s.pop();
                }
                s.push(price);
            }

            if (s.size() == 2) {
                ans = Math.max(s.get(1) - s.get(0), ans);
            }
        }
        return ans;
    }

    public int maxProfit3(int[] prices) {
        int ans = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - buy);
            }

        }
        return ans;
    }
}
