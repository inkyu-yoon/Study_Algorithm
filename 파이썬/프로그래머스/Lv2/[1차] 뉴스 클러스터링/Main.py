import math
def getSet(text):
    list = []
    for i in range(len(text) - 1):
        first = text[i]
        second = text[i + 1]
        if first.isalpha() and second.isalpha():
            list.append(first + second)
    return list


def solution(str1, str2):
    setA = getSet(str1.lower())
    setB = getSet(str2.lower())
    _set = set(setA + setB)
    union = 0
    common = 0
    for s in _set:
        common += min(setA.count(s), setB.count(s))
        union += max(setA.count(s), setB.count(s))

    if union == 0:
        return 65536
    answer = math.floor((common / union) * 65536)
    return answer