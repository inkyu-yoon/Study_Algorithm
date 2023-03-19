class Solution(object):
    def search(self, nums, target):
        idx = self.findMin(nums)
        findL = self.findIdx(nums, 0, idx - 1, target)
        findR = self.findIdx(nums, idx, len(nums) - 1, target)
        return max(findL, findR)

    def findIdx(self, nums, left, right, target):
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1

    def findMin(self, nums):
        left = 0
        right = len(nums) - 1

        if nums[left] <= nums[right]:
            return 0;

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        return left