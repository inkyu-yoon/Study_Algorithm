import sys
import heapq

N = int(input())

arr = [int(sys.stdin.readline()) for _ in range(N)]
heapq.heapify(arr)

ans = 0

while True:
    if len(arr)==1:
        break
    else:
        first = heapq.heappop(arr)
        second = heapq.heappop(arr)
        sum = first + second
        ans+=sum
        heapq.heappush(arr,sum)
print(ans)
