import sys

N, M = map(int, input().split())
arr = list(map(int, sys.stdin.readline().split()))

stack = []
checked = [False] * (N + 1)

arr.sort()
def bt():
    if len(stack) == M:
        print(*stack)
        return
    before = 0
    for i in range(N):
        if checked[i] == True or before == arr[i]:
            continue
        before = arr[i]
        stack.append(arr[i])
        checked[i] =True
        bt()
        stack.pop()
        checked[i]=False
bt()
