# N행 4열로 이루어져 있다.
# 각 행의 4칸 중 한 칸만 밟으면서 내려와야 한다.
# 같은 열은 반복해서 밟을 수 없다.

def solution(land):
    dp = [[0 for _ in range(4)] for _ in range(len(land) + 1)]

    for r in range(1, len(dp)):
        for i in range(4):
            dp[r][i] = land[r - 1][i] + max(dp[r - 1][:i] + dp[r - 1][i + 1:])

    answer = max(dp[-1])

    return answer