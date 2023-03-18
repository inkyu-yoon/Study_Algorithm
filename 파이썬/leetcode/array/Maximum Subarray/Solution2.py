class Solution(object):
    def maxSubArray(self, nums):
        dp = [-1e9]

        for idx in range(len(nums)):
            dp.append(max(dp[idx] + nums[idx], nums[idx]))

        return max(dp)
