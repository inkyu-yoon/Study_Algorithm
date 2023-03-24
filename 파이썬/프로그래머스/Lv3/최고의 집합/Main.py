# 자연수 n개로 이루어진 집합
# 각 원소의 합이 s가 되는 수의 집합
# 원소의 곱이 최대인 것을 반환
# 존재하지 않는 경우 -1 반환
def solution(n, s):
    answer = []
    if s // n == 0:
        return [-1]

    while n != 0:
        answer.append(s // n)
        s -= s // n
        n -= 1

    return answer