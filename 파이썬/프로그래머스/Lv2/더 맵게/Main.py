# 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + 두번째로 맵지 않은 음식의 스코빌 지수 * 2
# 모든 스코빌 지수가 K 이상이 될 때 까지 반복하여 섞는다.
import heapq


def solution(scoville, K):
    answer = 0
    foods = []

    for food in scoville:
        heapq.heappush(foods, food)

    while len(foods) != 0:
        most = heapq.heappop(foods)
        if most >= K:
            return answer
        if len(foods) == 0:
            break
        second = heapq.heappop(foods)
        result = most + 2 * second
        answer += 1
        heapq.heappush(foods, result)

    return -1