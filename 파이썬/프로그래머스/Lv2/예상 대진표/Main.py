import math


# 대회는 N명이 참가하고 토너먼트 형식이다.
# 1번,2번 경기 3번 4번 경기 .... N-1번 N번 경기
# 1번,2번 ..... N/2 -1 번 N/2번 경기 진행..
# A와 B는 언제 만나는가 구하기
def solution(n, a, b):
    answer = 0
    while a != b:
        a = math.ceil(a / 2)
        b = math.ceil(b / 2)
        answer += 1

    return answer