# 사용 할 수 있는 연산 x에 n을 더하기
# 2 곱하기 3곱하기
# x를 y로 만들기 위해 필요한 최소 연산 횟수
def solution(x, y, n):
    answer = 0
    if x == y:
        return 0
    _list = [1e9] * 3000003

    _list[x] = 1
    for i in range(x, y):
        if _list[i] != 1e9:
            _list[i + n] = min(_list[i + n], _list[i] + 1)
            _list[2 * i] = min(_list[2 * i], _list[i] + 1)
            _list[3 * i] = min(_list[3 * i], _list[i] + 1)
        if _list[y] != 1e9:
            return _list[y] - 1

    return -1