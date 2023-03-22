def solution(elements):
    answer = 0
    _set = set()
    rotated = elements+elements
    for i in range(len(elements)):
        for j in range(len(elements)):
            _set.add(sum(rotated[j:j+i+1]))
    answer = len(_set)
    return answer