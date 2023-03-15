N = int(input())

# 바닥 채우는 경우의 수
dp = [0]*(N+1)
dp[1] = 1
dp[2] = 3

for i in range(3,N+1):
    dp[i] = dp[i-1] + 2 * dp[i-2]
print(dp)
print(dp[N])

