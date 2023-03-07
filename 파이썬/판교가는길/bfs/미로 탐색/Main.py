import sys
from collections import deque

N,M = map(int,input().split())

_map = [[0]*M for _ in range(N)]

for row in range(N):
    info = sys.stdin.readline()
    for col in range(M):
        _map[row][col] = int(info[col])

queue = deque([])
checked = [[False]*M for _ in range(N)]

queue.append([0,0,1])
checked[0][0]=True

dr = [1,-1,0,0]
dc = [0,0,1,-1]

def bfs():
    while len(queue) !=0:
        point = queue.popleft()
        row = point[0]
        col = point[1]
        distance = point[2]
        for i in range(4):
            nRow = row + dr[i]
            nCol = col + dc[i]
            nDis = distance+1
            if 0<=nRow<N and 0<=nCol<M and _map[nRow][nCol] ==1 and not checked[nRow][nCol]:
                if nRow == N-1 and nCol == M-1:
                    print(nDis)
                    exit()
                queue.append([nRow,nCol,nDis])
                checked[nRow][nCol] = True
bfs()


