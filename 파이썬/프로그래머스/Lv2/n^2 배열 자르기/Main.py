def solution(n, left, right):
    answer = []

    # left 가 포함된 열
    rowL = (left) // n

    # right가 포함된 열
    rowR = (right) // n
    for i in range(rowL + 1, rowR + 2):
        answer += [i for _ in range(i)] + [i for i in range(i + 1, n + 1)]
    start = left % n
    end = n - (right % n) - 1
    if end != 0:
        answer = answer[start:-end]
    else:
        answer = answer[start:]

    return answer

# 123
# 223
# 333

# 1234
# 2234
# 3334
# 4444

# 12345
# 22345
# 33345
# 44445
# 55555