import sys

# 예제 입력
N, M, H = map(int, sys.stdin.readline().split())
ladders = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]
_map = [[0] * N for _ in range(H)]

# 사다리 정보 저장
# 왼쪽은 1 오른쪽은 -1로 저장
for ladder in ladders:
    ladderR = ladder[0] - 1
    ladderC = ladder[1] - 1
    _map[ladderR][ladderC] = 1
    _map[ladderR][ladderC + 1] = -1


# 모든 i번 결과가 i번 인가?
def isEqual():
    for i in range(N):
        location = i
        for step in range(H):
            if _map[step][location] == 1:
                location += 1
            elif _map[step][location] == -1:
                location -= 1
        if location != i:
            return False
    return True


plusNum = 0
ans = 4


def bt():
    global plusNum
    global ans

    if plusNum < ans and isEqual():
        ans = plusNum
        return
    if plusNum == 3:
        return

    for i in range(H):
        for j in range(N - 1):
            if abs(_map[i][j]) == 1 or abs(_map[i][j + 1]) == 1:
                continue
            _map[i][j] = 1
            _map[i][j + 1] = -1
            plusNum += 1
            bt()
            _map[i][j] = 0
            _map[i][j + 1] = 0
            plusNum -= 1


bt()
print(-1) if ans == 4 else print(ans)
