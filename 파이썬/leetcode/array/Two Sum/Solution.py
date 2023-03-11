class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}

        for i in range(len(nums)):
            dic[nums[i]] = i

        ans = []

        for i in range(len(nums)):
            num = target - nums[i]
            if num in dic and dic[num] != i:
                return [i, dic[num]]