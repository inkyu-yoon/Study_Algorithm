class Solution(object):
    def maxSubArray(self, nums):
        ans = nums[0]
        dp = [nums[0]]

        for i in range(1, len(nums)):
            dp.append(max(nums[i], dp[i - 1] + nums[i]))
            ans = max(ans, dp[i])

        return ans