# 야근 피로도 = 남은 일의 작업량의 제곱
# n만큼 일을 할 수 있다.
import heapq


def solution(n, works):
    answer = 0

    # 일을 다 끝낼 수 있는 경우
    if sum(works) <= n:
        return 0
    queue = []
    for work in works:
        heapq.heappush(queue, -1 * work)
    for i in range(n):
        work = heapq.heappop(queue)
        work += 1
        heapq.heappush(queue, work)
    for q in queue:
        answer += q * q
    return answer