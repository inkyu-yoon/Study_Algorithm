# N 범위, stations 기지국 설치, w 기지국 범위
import math


def solution(n, stations, w):
    answer = 0

    _list = []
    _min = 0

    for station in stations:
        num = station - w - 1 - _min
        if num > 0:
            _list.append(num)
        _min = station + w

    if stations[-1] + w < n:
        _list.append(n - (stations[-1] + w))

    for num in _list:
        answer += math.ceil(num / (2 * w + 1))

    return answer