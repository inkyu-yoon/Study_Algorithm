import sys

N,M = map(int,input().split())
cards = list(map(int,sys.stdin.readline().split()))

stack=[]
checked = [False]*(N+1)

ans = 0

cards.sort()

def dfs(start):
    global ans
    if len(stack)==3:
        sum = 0
        for card in stack:
            sum+=card
        if ans<sum and sum<=M:
            ans=sum
        return

    for i in range(start,N):
        if checked[i] ==True:
            continue
        if len(stack)>=1 and stack[-1]>cards[i]:
            continue
        stack.append(cards[i])
        checked[i]=True
        dfs(start+1)
        stack.pop()
        checked[i]=False

dfs(0)
print(ans)
