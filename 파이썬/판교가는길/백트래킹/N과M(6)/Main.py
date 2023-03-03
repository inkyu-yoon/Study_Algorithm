import sys

N, M = map(int, input().split())
nums = list(map(int, sys.stdin.readline().split()))

stack = []

nums.sort()
checked = [False] * (max(nums) + 1)


def bt():
    if len(stack) == M:
        print(*stack)
        return
    for i in nums:
        if checked[i] == True:
            continue

        if len(stack)>=1 and stack[-1]>i:
            continue

        stack.append(i)
        checked[i] = True
        bt()
        stack.pop()
        checked[i] = False


bt()
