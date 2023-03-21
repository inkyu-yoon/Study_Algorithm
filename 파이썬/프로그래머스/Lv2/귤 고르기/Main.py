def solution(k, tangerine):
    answer = 0
    tangerine.sort()
    dic = {}

    for num in tangerine:
        if num in dic:
            dic[num] += 1
        else:
            dic[num] = 1

    arr = []

    for value in dic.values():
        arr.append(value)

    arr.sort(reverse=True)

    for i in range(len(arr)):
        if k <= 0:
            break
        k -= arr[i]
        answer += 1

    return answer