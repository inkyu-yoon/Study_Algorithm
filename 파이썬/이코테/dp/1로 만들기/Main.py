N = int(input())
dp = [1e9]*(N+1)
dp[N]=0

for i in range(N,0,-1):
    dp[i-1]=min(dp[i]+1,dp[i-1])
    if i % 2 == 0:
        dp[i//2] = min(dp[i]+1,dp[i//2])
    if i % 3 == 0:
        dp[i//3] = min(dp[i]+1,dp[i//3])
    if i % 5 ==0:
        dp[i//5] = min(dp[i]+1,dp[i//5])

print(dp[1])