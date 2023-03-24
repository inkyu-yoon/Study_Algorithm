class Solution(object):
    def wordBreak(self, s, wordDict):
        dp = [False for _ in range(len(s))]
        print(dp)
        for i in range(len(s)):
            if s[:i+1] in wordDict:
                dp[i]=True
            for j in range(i):
                if dp[j] and s[j+1:i+1] in wordDict:
                    dp[i]=True

        return dp[-1]
