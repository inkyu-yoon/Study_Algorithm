N,M = map(int,input().split())

stack = []
checked= [False]*(N+1)
def bt(start):
    if len(stack) == M:
        print(*stack)
        return
    for i in range(start,N+1):
        stack.append(i)
        bt(i)
        stack.pop()

bt(1)