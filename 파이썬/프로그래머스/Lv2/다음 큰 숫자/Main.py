def solution(n):
    answer = 0

    numOfOne = (str)(format(n, 'b')).count('1')

    while True:
        n += 1
        binary = (str)(format(n, 'b'))

        if numOfOne == binary.count('1'):
            break

    return n