class Solution(object):
    def numDecodings(self, s):
        if s.startswith('0'):
            return 0
        dp = [1, 1]
        for i in range(2, len(s) + 1):
            num = s[i - 1]
            result = 0
            if num != '0':
                result = dp[-1]
            num = (int)(s[i - 2:i])
            if 10 <= num <= 26:
                result += dp[-2]
            dp.append(result)

        return dp[-1]
