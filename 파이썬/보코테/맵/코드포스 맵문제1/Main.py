# 구간합 알고리즘 사용
N = int(input())
arr = list(map(int, input().split()))

comSum = [0] * 200001
prefix_sum = {}
ans = 0

for i in range(N):
    if i == 0:
        prefix_sum[0] = "zero"
        prefix_sum[arr[i]] = "exist"
        comSum[i] = arr[i]
    else:
        sum = arr[i] + comSum[i - 1]
        comSum[i] = sum
        if sum in prefix_sum:
            ans += 1
            prefix_sum.clear()
            prefix_sum[0] = "zero"
            prefix_sum[arr[i]] = "exist"
            comSum[i] = arr[i]
        else:
            prefix_sum[sum] = "exist"
print(ans)
# -1 1 -1 1 -1 1 1 -1 -1
# -1 0 -1 0 -1 0 1 0 -1