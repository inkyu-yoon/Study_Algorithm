# 9 아기 상어의 위치
# 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
# 아기 상어는 최초 크기가 2이다. 자신의 크기만큼 물고기를 먹을때 사이즈 1이 늘어난다.
# 거리가 가까운 물고기가 많다면 가장 위에 있는 물고기, 그런 물고기가 여러마리라면 가장 왼쪽에 있는 물고기를 먹는다.
# 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하라
import sys
from collections import deque
import copy

N = int(input())
_map = [[0] * N for _ in range(N)]

queue = deque([])
startSharkR = 0
startSharkC = 0

for i in range(N):
    info = list(map(int, sys.stdin.readline().split()))
    for j in range(N):
        _map[i][j] = info[j]
        if info[j] == 9:
            startSharkR = i
            startSharkC = j

dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]

food = []


def bfs(shark):
    copiedMap = copy.deepcopy(_map)
    while len(queue) != 0:
        point = queue.popleft()
        row = point[0]
        col = point[1]
        time = point[2]
        for i in range(4):
            nr = row + dr[i]
            nc = col + dc[i]
            nt = time + 1

            if 0 <= nr < N and 0 <= nc < N:
                if copiedMap[nr][nc] == 0 or copiedMap[nr][nc] == shark:
                    copiedMap[nr][nc] = 1e9
                    queue.append([nr, nc, nt])
                elif copiedMap[nr][nc] < shark:
                    if [nr, nc, nt] not in food:
                        food.append([nr, nc, nt])

    if len(food) == 0:
        return [0]
    else:
        food.sort(key=lambda x: (x[2], x[0], x[1]))
        return food[0]


shark = 2
fish = 0
time = 0

while True:
    queue.clear()
    food.clear()
    queue.append([startSharkR, startSharkC, 0])
    _map[startSharkR][startSharkC] = 0
    result = bfs(shark)
    if len(result) == 1:
        break
    else:
        fish += 1
        startSharkR = result[0]
        startSharkC = result[1]
        time += result[2]
        _map[startSharkR][startSharkC] = 1e9
        if fish == shark:
            shark += 1
            fish = 0

print(time)
