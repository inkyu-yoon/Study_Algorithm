from collections import Counter


def solution(want, number, discount):
    answer = 0
    dic = {}
    for i in range(len(want)):
        dic[want[i]] = number[i]

    for i in range(len(discount) - 9):
        _list = discount[i:i + 10]
        if dic == Counter(_list):
            answer += 1

    return answer