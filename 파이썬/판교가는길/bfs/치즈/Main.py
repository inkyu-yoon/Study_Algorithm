from collections import deque
import sys
import copy
# 두 변 이상 접촉한 치즈는 1시간 이후에 사라진다.
# 두변이 접촉했다는 뜻은 주변에 빈 격자가 2개 이상 (내부공간 제외) 라는 뜻

row, col = map(int, input().split())

_map = [[0] * col for _ in range(row)]
checked = [[False] * col for _ in range(row)]
cheese = []

for i in range(row):
    info = list(map(int, sys.stdin.readline().split()))
    for j in range(col):
        if info[j] == 1:
            _map[i][j] = 1
            cheese.append([i, j])

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

queue = deque([])

air = []

removed = []
def removeCheese():
    removed.clear()
    for target in cheese:
        condition = 0
        r, c = map(int, target)
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < row and 0 <= nc < col and _map[nr][nc] == -1:
                condition += 1

        if condition >= 2:
            removed.append(target)
            _map[r][c] = 0
    for ch in removed:
        cheese.remove(ch)

def bfs():
    isAir = False
    copiedCheck = copy.deepcopy(checked)
    while queue:
        r, c = map(int, queue.popleft())
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < row and 0 <= nc < col and _map[nr][nc] == 0 and not copiedCheck[nr][nc]:
                queue.append([nr, nc])
                air.append([nr, nc])
                copiedCheck[nr][nc] = True
            if nr ==-1 or nr == row or nc ==-1 or nc == col or _map[nr][nc] == -1:
                isAir = True
    if isAir:
        for point in air:
            _map[point[0]][point[1]] = -1

ans = 0
while True:
    if not cheese:
        break

    for i in range(row):
        for j in range(col):
            if _map[i][j] == 0:
                queue.append([i, j])
                checked[i][j] = True
                air.append([i, j])
                bfs()
                air.clear()
    removeCheese()
    ans+=1


print(ans)
