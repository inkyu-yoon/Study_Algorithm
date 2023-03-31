class Solution(object):
    def canJump(self, nums):
        dp = [False for _ in range(len(nums))]
        dp[0] = True

        if len(nums) == 1:
            return True
        elif nums[0] == 0:
            return False
        idx = 0
        end = nums[0]
        while True:
            if idx == end or end >= len(nums):
                break
            idx += 1
            if end < idx + nums[idx]:
                end = idx + nums[idx]
        if end < len(nums) - 1:
            return False
        else:
            return True
