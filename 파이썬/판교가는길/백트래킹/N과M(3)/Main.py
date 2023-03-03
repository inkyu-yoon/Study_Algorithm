N,M = map(int,input().split())

stack =[]
checked = [False]*(N+1)
def bt():
    if len(stack)==M:
        print(*stack)
        return
    for i in range(1,N+1):
        stack.append(i)
        bt()
        stack.pop()
bt()