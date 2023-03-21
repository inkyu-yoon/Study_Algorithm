class Solution(object):
    def coinChange(self, coins, amount):

        dp = [0]

        for i in range(1, amount + 1):
            dp.append(1e9)
            for coin in coins:
                if i - coin < 0:
                    continue
                dp[i] = min(dp[i - coin] + 1, dp[i])

        ans = dp[amount] if dp[amount] != 1e9 else -1

        return ans