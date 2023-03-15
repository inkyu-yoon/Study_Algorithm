N, M = map(int, input().split())
arr = list(map(int, input().split()))

# 총합 M을 얻을 수 있는 절단기의 최대 높이
left = 0
right = max(arr)


def getTotal(height):
    sum = 0
    for i in arr:
        result = i - height
        if result > 0:
            sum += result

    return sum


while left <= right:
    mid = (left + right) // 2
    if M > getTotal(mid):
        right = mid - 1
    else:
        ans = mid
        left = mid + 1
print(ans)
'''
4 6
19 15 10 17

15
'''
