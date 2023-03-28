class Solution(object):
    def combinationSum4(self, nums, target):
        dp=[0]*(target+1)
        for i in range(1,target+1):
            for num in nums:
                idx = i-num
                if idx==0:
                    dp[i]+=1
                elif idx>0:
                    dp[i]+=dp[idx]
        return dp[-1]