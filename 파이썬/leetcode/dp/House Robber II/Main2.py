class Solution(object):
    def rob(self, nums):

        def custom_rob(nums):
            dp = [0, nums[0]]
            for i in range(2, len(nums) + 1):
                dp.append(max(dp[i - 1], dp[i - 2] + nums[i - 1]))
            return dp

        if len(nums) == 1:
            return nums[0]

        answer = max(custom_rob(nums[:len(nums) - 1]) + custom_rob(nums[1:]))
        return answer