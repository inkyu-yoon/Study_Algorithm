# 각 사원은 딱 한 번씩 경기를 한다.
# 숫자가 큰 쪽이 승리하고, 같다면 누구도 승점을 얻지 않는다.
# B팀이 얻을 수 있는 최대 승점을 구하라
def solution(A, B):
    answer = 0
    A = sorted(A)
    B = sorted(B)
    a, b = 0, 0
    while True:
        if A[a] < B[b]:
            answer += 1
            a += 1
            b += 1
        else:
            b += 1

        if b == len(B):
            break

    return answer