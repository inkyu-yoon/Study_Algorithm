class Solution(object):
    def longestCommonSubsequence(self, text1, text2):

        arr1, arr2 = list(text1), list(text2)
        C = len(arr1) + 1
        R = len(arr2) + 1
        dp = [[0 for _ in range(C)] for _ in range(R)]
        for col in range(1, C):
            target = arr1[col - 1]
            for row in range(1, R):
                if arr2[row - 1] == target:
                    dp[row][col] = dp[row - 1][col - 1] + 1
                else:
                    dp[row][col] = max(dp[row - 1][col], dp[row][col - 1])
        return dp[R - 1][C - 1]