# [최소 필요 피로도, 소모 피로도]
def explore(k, cases, dungeons):
    _max = 0
    for stack in cases:
        energy = k
        numOfdungeons = 0
        for i in stack:
            required, waste = dungeons[i]
            if required <= energy:
                energy -= waste
                numOfdungeons += 1
        _max = max(_max, numOfdungeons)
    return _max


def solution(k, dungeons):
    stack = []
    cases = []
    def bt():
        if len(stack) == len(dungeons):
            cases.append(list(stack))
            return
        for i in range(len(dungeons)):
            if i not in stack:
                stack.append(i)
                bt()
                stack.pop()
    bt()
    ans = explore(k, cases, dungeons)
    return ans