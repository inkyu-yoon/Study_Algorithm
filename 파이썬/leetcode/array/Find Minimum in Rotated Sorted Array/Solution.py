class Solution(object):
    def findMin(self, nums):
        left = 0
        right = len(nums)-1

        while right-left > 1:
            mid = (right+left)//2
            if nums[mid] >= nums[right]:
                left = mid
            else:
                right = mid
        return min(nums[left],nums[right])