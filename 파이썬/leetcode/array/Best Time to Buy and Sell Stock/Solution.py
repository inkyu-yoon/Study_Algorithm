class Solution(object):
    def maxProfit(self, prices):

        ans = 0
        buy = 1e9

        for i in range(len(prices)):
            if buy > prices[i]:
                buy = prices[i]
            else:
                ans = max(ans, prices[i] - buy)

        return ans