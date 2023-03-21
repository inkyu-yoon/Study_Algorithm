from collections import Counter

def solution(k, tangerine):
    answer = 0
    counter = Counter(tangerine)

    values = counter.values()
    values = sorted(values, reverse=True)

    for i in values:
        if k <= 0:
            break
        k -= i
        answer += 1

    return answer