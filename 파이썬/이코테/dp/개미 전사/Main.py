N = int(input())
foods = list(map(int, input().split()))

# 인접한 창고가 공격받으면 알아차림
dp = [0]*(N+1)
dp[1]=foods[0]
dp[2]=foods[1]

for i in range(3,5):
    dp[i]=max(dp[i-1],foods[i-1]+dp[i-2])

print(max(dp))
'''
4
1 3 1 5
'''