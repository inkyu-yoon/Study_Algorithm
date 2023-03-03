N,M = map(int,input().split())

stack = []
checked = [False]*(N+1)
def bt(start):
    if len(stack) == M:
        print(*stack)
        return
    for i in range(start,N+1):
        if checked[i]:
            continue
        stack.append(i)
        checked[i]=True
        bt(i+1)
        stack.pop()
        checked[i]=False

bt(1)