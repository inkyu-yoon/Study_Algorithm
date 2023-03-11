class Solution(object):
    def containsDuplicate(self, nums):
        dic = {}

        for i in range(len(nums)):

            if nums[i] in dic:
                return True

            dic[nums[i]] = i

