def getGcd(a, b, lcm):
    return (a * b) / lcm


def getLcm(a, b):
    if b == 0:
        return a
    else:
        return getLcm(b, a % b)


def solution(arr):
    target = arr[0]
    for i in range(1, len(arr)):
        lcm = getLcm(target, arr[i])
        gcd = getGcd(target, arr[i], lcm)
        target = gcd

    return target