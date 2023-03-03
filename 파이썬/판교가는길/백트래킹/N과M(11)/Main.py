import sys

N,M = map(int,input().split())
arr = list(map(int,sys.stdin.readline().split()))
arr.sort()

stack =[]
checked = [False]*(N+1)
def bt():
    if len(stack) == M:
        print(*stack)
        return
    before = 0
    for i in range(N):
        if before == arr[i]:
            continue
        before = arr[i]
        stack.append(arr[i])
        bt()
        stack.pop()

bt()