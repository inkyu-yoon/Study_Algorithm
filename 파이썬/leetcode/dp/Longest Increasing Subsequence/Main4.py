class Solution(object):
    def lengthOfLIS(self, nums):
        sub = [nums[0]]

        def bs(target):
            left = 0
            right = len(sub) - 1
            while left <= right:
                mid = (left + right) // 2
                if sub[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left

        for i in range(1, len(nums)):
            if sub[-1] < nums[i]:
                sub.append(nums[i])
            else:
                idx = bs(nums[i])
                sub[idx] = nums[i]
        return len(sub)
