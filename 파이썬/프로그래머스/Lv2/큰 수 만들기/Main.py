def solution(number, k):
    answer = ''
    stack = []

    for i in range(len(number)):
        if not stack :
            stack.append(number[i])
        else:
            if stack[-1]>=number[i]:
                stack.append(number[i])
            else:
                while stack and stack[-1]<number[i] and k!=0:
                    stack.pop()
                    k-=1
                stack.append(number[i])
    if k==0:
        return ''.join(stack)
    else:
        return ''.join(stack[:-k])
