def solution(clothes):
    answer = 1

    dic = {}

    for cloth in clothes:
        if cloth[1] not in dic:
            dic[cloth[1]] = 1
        else:
            dic[cloth[1]] += 1

    for value in dic.values():
        answer *= (value + 1)
    answer -= 1

    return answer