import sys

def bt(start):
    if len(stack)==6:
        print(*stack)
        return

    for i in range(start,N):
        if checked[i] ==True:
            continue
        if len(stack)>=1 and stack[-1] > nums[i]:
            continue
        stack.append(nums[i])
        checked[i]=True
        bt(start+1)
        stack.pop()
        checked[i]=False



while True:
    input = list(map(int,sys.stdin.readline().split()))
    N = input[0]
    if N ==0:
        break

    nums = input[1:]
    stack = []
    checked = [False]*(N+1)
    bt(0)
    print()