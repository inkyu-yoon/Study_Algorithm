# 구간합 알고리즘 사용
N = int(input())
arr = list(map(int, input().split()))

cumSum = {}
answer = 0

for i in range(N):

    if i == 0:
        cumSum["zero"] = 0
        cumSum[i] = arr[i]
    else:
        sum = arr[i] + cumSum[i - 1]
        if sum in cumSum.values():
            answer += 1
            cumSum.clear()
            cumSum["zero"] = 0
            cumSum[i] = arr[i]
        else:
            cumSum[i] = sum
    print("cumSum",cumSum)


print(answer)