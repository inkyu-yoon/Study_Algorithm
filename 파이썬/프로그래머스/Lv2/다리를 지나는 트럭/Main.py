# 2 10 [7,4,5,6] 8
from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = deque([0 for _ in range(bridge_length)], maxlen=bridge_length)
    idx = 0
    _sum = 0
    while idx < len(truck_weights):
        out = bridge.popleft()
        _sum -= out
        if _sum + truck_weights[idx] <= weight:
            bridge.append(truck_weights[idx])
            _sum += truck_weights[idx]
            idx += 1
        else:
            bridge.append(0)
        answer += 1
    answer += bridge_length

    return answer