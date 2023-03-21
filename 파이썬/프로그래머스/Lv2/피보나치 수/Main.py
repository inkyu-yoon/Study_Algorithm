def solution(n):
    answer = 0

    fibo = [0]
    fibo.append(1)

    for i in range(2, n + 1):
        result = (fibo[i - 2] + fibo[i - 1]) % 1234567
        fibo.append(result)

    return fibo[n]