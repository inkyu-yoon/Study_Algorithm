# 주어진 화폐 단위로 (N개) M원을 만드는데 최소의 화폐 개수

N,M = map(int,input().split())
money = []
for _ in range(N):
    money.append(int(input()))

dp = [1e9]*10001

for m in money:
    dp[m] = 1


for i in range(max(money)+1,M+1):
    for m in money:
        dp[i]=min(dp[i],dp[i-m]+1)

print(dp[M] if dp[M]!=1e9 else -1)


'''
2 15
2
3

5

3 4
3
5
7

-1
'''