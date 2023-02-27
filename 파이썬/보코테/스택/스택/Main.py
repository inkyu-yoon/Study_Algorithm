import sys

def isEmpty(stack):
    if(len(stack)==0):
        return print(1)
    else:
        return print(0)


N = int(input())
stack = []

for _ in range(N):
    command = sys.stdin.readline().split()
    if(command[0]=='push'):
        stack.append(command[1])
    elif(command[0]=='pop'):
        if(len(stack)==0):
            print(-1)
        else:
            print(stack.pop())
    elif(command[0]=='size'):
        print(len(stack))
    elif(command[0]=='empty'):
        isEmpty(stack)
    elif(command[0]=='top'):
        if(len(stack)==0):
            print(-1)
        else:
            print(stack[-1])


