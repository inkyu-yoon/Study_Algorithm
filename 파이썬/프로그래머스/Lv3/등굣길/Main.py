# 격자 크기는 m(가로)c과 n(세로)r
def solution(c, r, puddles):
    answer = 0
    _map = [[0 for _ in range(c)] for _ in range(r)]

    for puddle in puddles:
        col, row = puddle
        _map[row - 1][col - 1] = 1

    dp = [[0 for _ in range(c + 1)] for _ in range(r + 1)]
    dp[1][1] = 1

    for row in range(1, r + 1):
        for col in range(1, c + 1):
            if row == 1 and col == 1:
                continue
            if _map[row - 1][col - 1] == 1:
                continue
            dp[row][col] = dp[row - 1][col] + dp[row][col - 1]

    return dp[-1][-1] % 1000000007