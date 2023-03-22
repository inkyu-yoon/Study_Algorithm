from collections import deque


def solution(priorities, location):
    queue = deque()
    for i in range(len(priorities)):
        queue.append([i, priorities[i]])
    turn = 0
    priorities.sort()

    target = priorities[-1]

    while True:
        index, document = queue.popleft()
        if target == document:
            turn += 1
            if index == location:
                break;
            priorities.pop()
            target = priorities[-1]
        else:
            queue.append([index, document])

    return turn