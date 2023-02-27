
stack = []
stick = input()
num = 0
for i in range(len(stick)):
    if(stick[i]=='('):
        stack.append('(')
    elif(stick[i]==')'):
        stack.pop()
        if(stick[i-1]==')'):
            num+=1
        else:
            num+=len(stack)
print(num)
# 레이저가 아닌데 )로 끝나는 경우 +1 해주어야함