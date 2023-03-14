# 00시 00분 00초 부터 N시 59분 59초까지 3이 하나라도 포함되는 모든 경우의 수 (0이상 23이하)

N = int(input())

ans = 0
for h in range(N+1):
    for m in range(60):
        for s in range(60):
            if '3' in (str)(h)+(str)(m)+(str)(s):
                ans+=1
print(ans)