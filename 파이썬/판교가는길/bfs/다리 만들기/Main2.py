import sys
from collections import deque

N = int(input())
_map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


# 섬 라벨링
def labeling(label):
    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = dr[i] + r
            nc = dc[i] + c
            if 0 <= nr < N and 0 <= nc < N and _map[nr][nc] == 1:
                _map[nr][nc] = label
                queue.append([nr, nc])


label = -1
queue = deque([])

for r in range(N):
    for c in range(N):
        if _map[r][c] == 1:
            _map[r][c] = label
            queue.append([r, c])
            labeling(label)
            label -= 1

# 육지 좌표 구하기

for r in range(N):
    for c in range(N):
        if _map[r][c] < 0:
            queue.append([r, c])

ans = 1e9
distanceMap = [[0] * N for _ in range(N)]


def bfs():
    global ans
    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = dr[i] + r
            nc = dc[i] + c
            if 0 <= nr < N and 0 <= nc < N:
                # 구한 육지 좌표가 바다와 인접한 경우에만 로직 실행
                if _map[nr][nc] == 0:
                    queue.append([nr, nc])
                    _map[nr][nc] = _map[r][c]
                    distanceMap[nr][nc] = distanceMap[r][c] + 1
                # 다른 육지에서 출발한 영역과 만난 경우 ( 다른 육지에서 출발한 영역은 음수로 입력되므로)
                elif _map[nr][nc] < 0 and _map[nr][nc] != _map[r][c]:
                    ans = min(ans,distanceMap[nr][nc]+distanceMap[r][c])


bfs()
print(ans)
