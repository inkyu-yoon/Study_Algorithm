def solution(topping):
    answer = 0
    size = len(topping)
    if size == 1:
        return answer

    arr1 = [1] * size
    arr2 = [1] * size
    _set = set([topping[0]])
    for i in range(1, size):
        if topping[i] in _set:
            arr1[i] = arr1[i - 1]
        else:
            arr1[i] = arr1[i - 1] + 1
            _set.add(topping[i])

    _set = set([topping[size - 1]])
    for i in range(size - 2, -1, -1):
        if topping[i] in _set:
            arr2[i] = arr2[i + 1]
        else:
            arr2[i] = arr2[i + 1] + 1
            _set.add(topping[i])

    for i in range(0, size - 1):
        if arr1[i] == arr2[i + 1]:
            answer += 1

    return answer