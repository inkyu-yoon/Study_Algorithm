N, K = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)

aIdx = 0
bIdx = 0
while True:
    if A[aIdx]<B[bIdx]:
        A[aIdx]=B[bIdx]
        aIdx+=1
        bIdx+=1
        K-=1
    else:
        bIdx+=1
    if bIdx == N or K == 0:
        break

print(sum(A))
'''
5 3
1 2 5 4 3
5 5 6 6 5

26
'''
