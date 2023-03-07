import sys
import copy
from collections import deque


N, M = map(int, input().split())
_map = [[0] * M for _ in range(N)]

for i in range(N):
    info = list(map(int, sys.stdin.readline().split()))
    for j in range(M):
        if info[j] != 0:
            _map[i][j] = info[j]
# 벽은 꼭 3 개를 세워야함 0 은 빈칸 / 1은 벽 / 2는 바이러스 위치

queue = deque([])

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

stack= []

ans = -1e9
# 바이러스가 다 퍼졌을 때 결과 반환
def bfs():
    global ans
    copiedMap = copy.deepcopy(_map)
    for i in range(N):
        for j in range(M):
            if copiedMap[i][j] == 2:
                queue.append([i, j])

    while len(queue) != 0:
        point = queue.popleft()
        row = point[0]
        col = point[1]
        for i in range(4):
            nRow = row + dr[i]
            nCol = col + dc[i]
            if 0 <= nRow < N and 0 <= nCol < M and copiedMap[nRow][nCol] == 0:
                queue.append([nRow, nCol])
                copiedMap[nRow][nCol] = 2
    safeArea = 0
    for i in range(N):
        safeArea += copiedMap[i].count(0)
    ans = max(ans,safeArea)

def bt(num):
    if num == 3:
        bfs()
        return

    for i in range(N):
        for j in range(M):
            if _map[i][j]==0:
                _map[i][j]=1
                bt(num+1)
                _map[i][j]=0

bt(0)
print(ans)


