def solution(triangle):
    answer = 0

    for i in range(1, len(triangle)):
        floor = triangle[i]
        for j in range(len(floor)):
            if j == 0:
                triangle[i][j] += triangle[i - 1][j]
            elif j == len(floor) - 1:
                triangle[i][j] += triangle[i - 1][j - 1]
            else:
                triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])

    answer = max(triangle[-1])
    return answer