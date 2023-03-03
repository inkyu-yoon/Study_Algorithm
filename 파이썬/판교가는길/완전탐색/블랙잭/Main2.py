import sys

def dfs():
    global ans
    if len(stack)==3:
        sum = cards[stack[0]]+cards[stack[1]]+cards[stack[2]]
        if M >= sum and sum>ans:
            ans = sum

    for i in range(N):
        if checked[i] == True:
            continue
        stack.append(i)
        checked[i] = True
        dfs()
        stack.pop()
        checked[i] = False

N,M = map(int,sys.stdin.readline().split())
cards = list(map(int,sys.stdin.readline().split()))

ans = -1

stack = []
checked =[False]*(N+1)
dfs()
print(ans)