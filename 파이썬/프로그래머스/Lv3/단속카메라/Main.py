def solution(routes):
    answer = 0
    routes = sorted(routes, key=lambda x: x[0])

    target = routes[0][1]

    for i in range(1, len(routes)):
        start, end = routes[i]
        if end < target:
            target = end

        if start > target:
            answer += 1
            target = end
    answer += 1
    return answer