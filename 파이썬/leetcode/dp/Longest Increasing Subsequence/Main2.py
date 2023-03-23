class Solution(object):
    def lengthOfLIS(self, nums):

        def bisect(sub,target):
            left = 0
            right = len(sub)-1
            while left<=right:
                mid = (left+right)//2
                if sub[mid]<target:
                    left = mid +1
                else:
                    right = mid-1
            return left

        sub = [nums[0]]
        for i in range(1,len(nums)):
            if sub[-1]>=nums[i]:
                idx = bisect(sub,nums[i])
                sub[idx]=nums[i]
            else:
                sub.append(nums[i])
        print(sub)
        return len(sub)

# 복습