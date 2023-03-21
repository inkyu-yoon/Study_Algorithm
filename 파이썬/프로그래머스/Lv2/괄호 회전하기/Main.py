from collections import deque

left = set(('{', '[', '('))
right = set(('}', ']', ')'))


def check(queue):
    stack = []
    for i in range(len(queue)):
        if len(stack) == 0:
            if queue[i] in right:
                return False
            else:
                stack.append(queue[i])
        else:
            if queue[i] in left:
                stack.append(queue[i])
            elif queue[i] in right:
                if queue[i] == '}' and stack[-1] == '{':
                    stack.pop()
                elif queue[i] == ')' and stack[-1] == '(':
                    stack.pop()
                elif queue[i] == ']' and stack[-1] == '[':
                    stack.pop()
                else:
                    return False
    if len(stack) == 0:
        return True
    else:
        return False


def solution(s):
    answer = 0
    queue = deque(list(s))
    for i in range(len(queue)):
        if check(queue):
            answer += 1
        queue.append(queue.popleft())

    return answer