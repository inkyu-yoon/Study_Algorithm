
N,M = map(int,input().split())
balls = list(map(int,input().split()))

# 서로 다른 무게의 볼링공을 선택해야함

ans = 0

for i in range(0,N-1):
    for j in range(i,N):
        if balls[i]!=balls[j]:
            ans+=1

print(ans)




'''
5 3
1 3 2 3 2

8 5
1 5 4 3 2 4 5 2
'''