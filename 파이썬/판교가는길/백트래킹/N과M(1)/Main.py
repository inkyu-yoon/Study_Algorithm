def dfs():
    if len(stack)==M:
        print(" ".join(map(str,stack)))

    for i in range(1,N+1):
        if checked[i]==True:
            continue
        stack.append(i)
        checked[i] = True
        dfs()
        stack.pop()
        checked[i] = False



N,M = map(int,input().split())
stack = []
checked = [False]*(N+1)
dfs()