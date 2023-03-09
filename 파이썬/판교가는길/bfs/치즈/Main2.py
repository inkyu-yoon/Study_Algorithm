import sys
from collections import deque
input = sys.stdin.readline

row,col = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(row)]

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

def bfs():
    q = deque()
    q.append([0,0])
    visited[0][0] = 1
    while q:
        r,c = q.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0<=nr<row and 0<=nc<col and visited[nr][nc] == 0:
                if graph[nr][nc] >= 1:
                    graph[nr][nc] += 1
                else:
                    visited[nr][nc] = 1
                    q.append([nr,nc])
time = 0

while 1:
    visited = [[0]*col for _ in range(row)]
    bfs()
    isRemoved = False
    for i in range(row):
        for j in range(col):
            if graph[i][j] >= 3:
                graph[i][j] = 0
                isRemoved = True
            elif graph[i][j] == 2:
                graph[i][j] = 1
    if isRemoved == 1:
        time += 1
    else:
        break

print(time)