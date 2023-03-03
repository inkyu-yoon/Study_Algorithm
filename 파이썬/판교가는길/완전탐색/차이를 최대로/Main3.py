import sys

def next_permutation(arr):
    k=-1
    target = -1
    for i in range(len(arr)-1):
        if arr[i] < arr[i+1]:
            k=i

    if k==-1:
        return [-1]

    for i in range(k+1,len(arr)):
        if arr[k]<arr[i]:
            target = i

    arr[k],arr[target]=arr[target],arr[k]

    return arr[:k+1]+sorted(arr[k+1:])



N = int(input())
arr = list(map(int,sys.stdin.readline().split()))
arr.sort()
ans = -1

for i in range(N-1):
    ans +=abs(arr[i]-arr[i+1])

while True:
    arr = next_permutation(arr)
    sum = 0
    if arr == [-1]:
        break
    for i in range(N-1):
        sum+=abs(arr[i]-arr[i+1])
    ans = max(ans,sum)
print(ans)