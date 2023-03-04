import sys
N = int(input())
nums = list(map(int,sys.stdin.readline().split()))
nums.sort()


def narayana_pandits(nums):

    k = -1
    for i in range(0,N-1):
        if nums[i] < nums[i+1]:
            k=i

    if k == -1:
        return [-1]
    target = k
    for i in range(k+1,N):
        if nums[k]<nums[i]:
            target = i

    nums[k],nums[target] = nums[target],nums[k]
    result = nums[0:k+1] + sorted(nums[k+1:])

    return result

ans = 0
sum = 0

for i in range(0,N-1):
    sum+=abs(nums[i]-nums[i-1])
ans = sum

while True:
    nums=narayana_pandits(nums)

    if nums == [-1]:
        break;

    sum = 0

    for i in range(0,N-1):
        sum+=abs(nums[i]-nums[i-1])

    ans = max(sum,ans)

print(ans)
