import re
from collections import Counter


def solution(s):
    answer = []

    s = Counter(re.findall('\d+', s))
    s = sorted(s.items(), key=lambda x: -x[1])

    for i in s:
        answer.append(i[0])
    answer = list(map(int, answer))

    return answer