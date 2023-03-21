from collections import deque


def findIdx(queue, city):
    for i in range(len(queue)):
        if queue[i] == city:
            return i


def solution(cacheSize, cities):
    answer = 0
    queue = deque([])

    for city in cities:
        city = city.lower()
        if city not in queue:
            answer += 5
            queue.append(city)

            if len(queue) == cacheSize + 1:
                queue.popleft()
        else:
            answer += 1
            idx = findIdx(queue, city)
            del queue[idx]
            queue.append(city)

    return answer