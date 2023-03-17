import heapq


def solution(food_times, k):
    answer = -1

    # 음식 총합 보다 k가 크면 섭취할 음식이 없어지므로 -1 반환
    if sum(food_times) <= k:
        return -1

    foods = []
    # 우선순위 큐에 [음식양,음식번호] 입력, 음식양을 기준으로 오름차순 정렬이 되어있을 것
    for i in range(len(food_times)):
        heapq.heappush(foods, [food_times[i], i + 1])

    eat = 0

    while foods:
        # 음식을 다 먹는데 걸리는 시간 (최소부터)
        time = (foods[0][0] - eat) * len(foods)

        if time <= k:
            food, idx = heapq.heappop(foods)
            k -= time
            eat = food
        else:
            idx = k % len(foods)
            foods.sort(key=lambda x: x[1])
            return foods[idx][1]

    return answer
