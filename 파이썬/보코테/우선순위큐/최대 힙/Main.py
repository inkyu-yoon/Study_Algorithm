# 배열에 자연수 x를 넣는다
# 가장 큰 값을 출력하고, 배열에서 제거한다.
# 0이라면 배열에서 가장 큰 값을 출력하고 제거한다.
# 최소 힙
import sys
import heapq

N = int(input())
arr = []

for _ in range(N):
    num = int(sys.stdin.readline())
    if num == 0:
        if len(arr) == 0:
            print(0)
        else:
            print(-1 * heapq.heappop(arr))
    else:
        heapq.heappush(arr,-1*num)
