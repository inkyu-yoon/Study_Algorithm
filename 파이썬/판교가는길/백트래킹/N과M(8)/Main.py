import sys

N, M = map(int, input().split())
nums = list(map(int, sys.stdin.readline().split()))

stack = []

nums.sort()



def bt():
    if len(stack) == M:
        print(*stack)
        return
    for i in nums:
        if len(stack)>=1 and stack[-1]>i:
            continue

        stack.append(i)
        bt()
        stack.pop()



bt()
