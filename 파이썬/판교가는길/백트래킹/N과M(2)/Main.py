N,M = map(int,input().split())
stack = []
def dfs(start):
    if len(stack) == M :
        print(*stack)
        return

    for i in range(start,N+1):
        if i not in stack:
            stack.append(i)
            dfs(i+1)
            stack.pop()

dfs(1)