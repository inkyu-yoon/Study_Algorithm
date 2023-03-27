# 한 번에 한 개의 알파벳만 바꿀 수 있다.
# words에 있는 단어로만 변경할 수 있다.
# hit hot dot dog cog
from collections import deque


def canChange(a, b):
    textA = list(a)
    textB = list(b)
    result = 0
    for i in range(len(textA)):
        if textA[i] != textB[i]:
            result += 1
        if result > 2:
            return False
    if result == 1:
        return True


def solution(begin, target, words):
    answer = 0

    if target not in words:
        return 0
    q = deque()
    q.append([begin, 0])
    while q:
        text, num = q.popleft()
        for word in words:
            if canChange(text, word):
                if word == target:
                    return num + 1
                q.append([word, num + 1])

    return answer