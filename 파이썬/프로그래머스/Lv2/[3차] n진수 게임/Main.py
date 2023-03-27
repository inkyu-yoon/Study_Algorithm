# 0 1 2 3 ...8 9 0 [1 1] [1 2] [1 3] ...
# 진법 n (2 ~ 16) 미리 구할 숫자의 갯수 t 게임에 참가하는 인원 m 튜브의 순서 p
def getNum(n):
    unit = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F']
    unit = unit[:n]
    result = '0'
    start = 0
    while len(result) < 100 * 1000:
        target = start
        res = ''
        while target != 0:
            res += unit[target % n]
            target = target // n
        start += 1
        result += res[::-1]

    return result


def solution(n, t, m, p):
    answer = ''

    result = getNum(n)

    while len(answer) < t:
        answer += result[p - 1]
        p += m

    return answer