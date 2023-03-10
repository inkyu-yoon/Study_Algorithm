import sys
from collections import deque
import copy

row, col = map(int, input().split())
_map = [list(map(int, sys.stdin.readline().split())) for _ in range(row)]

queue = deque([])
checked = [[False]*col for _ in range(row)]


dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def bfs():
    copiedCheck = copy.deepcopy(checked)
    queue.append([0, 0])
    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < row and 0 <= nc < col:
                if _map[nr][nc] == 0 and not copiedCheck[nr][nc]:
                    queue.append([nr, nc])
                    copiedCheck[nr][nc]=True
                elif _map[nr][nc]>0 :
                    _map[nr][nc]+=1

time = 0

while True:

    bfs()
    isRemoved = False
    for r in range(row):
        for c in range(col):
            if _map[r][c]>=3:
                isRemoved = True
                _map[r][c]=0
            elif 0<_map[r][c]<=2:
                _map[r][c]=1
    if isRemoved:
        time+=1
    else:
        break

print(time)

