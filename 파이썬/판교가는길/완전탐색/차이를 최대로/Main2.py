import sys


def next(arr):
    k = -1
    target = -1
    for i in range(len(arr) - 1):
        if arr[i] < arr[i + 1]:
            k = i

    # 내림차순 정렬로 되어 있는 경우
    if k == -1:
        return [-1]

    for i in range(k, len(arr)):
        if arr[k] < arr[i]:
            target = i

    arr[k], arr[target] = arr[target], arr[k]

    arr = arr[:k + 1] + sorted(arr[k + 1:])

    return arr


N = int(input())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

max = -1
while True:
    arr = next(arr)
    if arr == [-1]:
        break
    sum = 0
    for i in range(N - 1):
        sum += abs(arr[i + 1] - arr[i])
    if sum > max:
        max = sum

print(max)
