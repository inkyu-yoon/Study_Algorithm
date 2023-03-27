class Solution(object):
    def combinationSum4(self, nums, target):
        dp = [0] * (target+1)
        dp[0] = 1
        for i in range(1, target+1):
            for num in nums:
                j = i - num
                if j >= 0:
                    dp[i] += dp[j]
        return dp[target]