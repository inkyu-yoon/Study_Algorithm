class Solution(object):
    def maxProduct(self, nums):
        _max = nums[0]
        _min = nums[0]
        ans = nums[0]

        for i in range(1, len(nums)):
            maxResult = max(max(nums[i], _max * nums[i]), _min * nums[i])
            minResult = min(min(nums[i], _max * nums[i]), _min * nums[i])

            _max = maxResult
            _min = minResult

            ans = max(ans, maxResult)

        return ans
