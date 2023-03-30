class Solution(object):
    def numDecodings(self, s):
        if s.startswith('0'):
            return 0

        dp = [1, 1]
        for i in range(1, len(s)):
            _sum = 0
            if '1' <= s[i] <= '9':
                _sum += dp[i]
            if '10' <= s[i - 1] + s[i] <= '26':
                _sum += dp[i - 1]
            dp.append(_sum)
        print(dp)

        return dp[-1]