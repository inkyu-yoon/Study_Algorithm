class Solution(object):
    def maxProduct(self, nums):
        _min = [nums[0]]
        _max = [nums[0]]
        dp = [nums[0]]

        for idx in range(1, len(nums)):
            _max.append(max(max(nums[idx], _max[idx - 1] * nums[idx]), _min[idx - 1] * nums[idx]))
            _min.append(min(min(nums[idx], _max[idx - 1] * nums[idx]), _min[idx - 1] * nums[idx]))
            dp.append(_max[idx])

        return max(dp)



