class Solution(object):
    def rob(self, nums):
        dp = [0] * 101
        dp[1] = nums[0]
        if len(nums) == 1:
            return nums[0]

        for i in range(1, len(nums)):
            dp[i + 1] = max(dp[i - 1] + nums[i], dp[i])

        return dp[len(nums)]


