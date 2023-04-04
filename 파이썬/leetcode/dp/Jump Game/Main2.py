class Solution(object):
    def canJump(self, nums):

        _max = 0
        for i in range(len(nums)):
            if _max < i + nums[i]:
                _max = i + nums[i]

            if _max == i or _max >= len(nums) - 1:
                break
        if _max < len(nums) - 1:
            return False
        else:
            return True
