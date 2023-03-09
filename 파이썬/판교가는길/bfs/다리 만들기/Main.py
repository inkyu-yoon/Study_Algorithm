from collections import deque
import sys

N = int(input())
_map = [[0] * N for _ in range(N)]
distanceMap = [[0] * N for _ in range(N)]

# map 입력

for i in range(N):
    info = list(map(int, sys.stdin.readline().split()))
    for j in range(N):
        if info[j] == 1:
            _map[i][j] = 1

queue = deque([])
land = deque([])
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

# 섬 라벨링

label = -1

def bfs(label):
    while queue:
        r,c = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0<=nr<N and 0<=nc<N and _map[nr][nc] ==1:
                _map[nr][nc] = label
                queue.append([nr,nc])
                land.append([nr,nc,0])




for i in range(N):
    for j in range(N):
        if _map[i][j] >0:
            queue.append([i,j])
            land.append([i,j,0])
            _map[i][j]=label
            bfs(label)
            label-=1

checked = [[False] * N for _ in range(N)]

ans = 1e9
def bfs2():
    global ans
    while land:
        r,c,d = map(int,land.popleft())
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            nd = d + 1
            if 0 <= nr < N and 0 <= nc < N :
                    if _map[nr][nc] == 0:
                        _map[nr][nc] = _map[r][c]
                        land.append([nr,nc,nd])
                        distanceMap[nr][nc]=nd
                    elif _map[nr][nc] <0 and _map[nr][nc]!=_map[r][c]:
                        ans = min(ans,distanceMap[r][c]+distanceMap[nr][nc])
bfs2()

print(ans)
# for i in range(N):
#     print(*_map[i])
# for i in range(N):
#     print(*distanceMap[i])