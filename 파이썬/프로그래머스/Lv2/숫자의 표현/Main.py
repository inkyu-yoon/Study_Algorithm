def solution(n):
    answer = 0

    for i in range(1, n + 1):
        result = 0
        start = i
        while result < n:
            result += start
            start += 1

        if result == n:
            answer += 1

    return answer