#N이 1이 될 때 까지 반복한다. 두 과정중 선택해서
# N에서 1을 뺀다.
# N을 K로 나눈다. (나누어 떨어지는 경우만)

N,K = map(int,input().split())

ans = 0

while N !=1:
    if N%K == 0:
        N//=K
    else:
        N-=1
    ans+=1
print(ans)


'''
25 5

2
'''