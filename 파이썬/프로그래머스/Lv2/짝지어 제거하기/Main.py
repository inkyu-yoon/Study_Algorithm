def solution(s):
    answer = -1

    stack = []
    _list = list(s)

    for i in range(len(_list)):
        if len(stack) == 0:
            stack.append(_list[i])
        else:
            if stack[-1] == _list[i]:
                stack.pop()
            else:
                stack.append(_list[i])
    answer = 1 if len(stack) == 0 else 0

    return answer