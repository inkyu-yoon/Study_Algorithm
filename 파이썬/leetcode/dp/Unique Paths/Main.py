class Solution(object):
    def uniquePaths(self, m, n):
        R = m
        C = n
        dp = [[0 for _ in range(C + 1)] for _ in range(R + 1)]
        dp[1][1] = 1
        for r in range(1, R + 1):
            for c in range(1, C + 1):
                dp[r][c] += dp[r - 1][c] + dp[r][c - 1]
        return dp[-1][-1]

