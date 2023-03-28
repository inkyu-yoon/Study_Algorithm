class Solution(object):
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]

        def rob(nums):
            dp = [0]
            dp.append(nums[0])
            for i in range(2, len(nums) + 1):
                dp.append(max(dp[i - 1], dp[i - 2] + nums[i - 1]))

            return dp

        result1 = (rob(nums[1:]))
        result2 = (rob(nums[:-1]))
        return max(result1[-1], result2[-1])