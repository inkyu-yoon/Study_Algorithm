import sys
from collections import deque

N = int(input())
_map = [[0] * N for _ in range(N)]
queue = deque([])
for i in range(N):
    info = input()
    for j in range(len(info)):
        _map[i][j] = int(info[j])

checked = [[False] * N for _ in range(N)]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

list = []
def bfs():
    num = 1
    while len(queue) != 0:
        point = queue.popleft()
        row = point[0]
        col = point[1]

        for i in range(4):
            nRow = row + dr[i]
            nCol = col + dc[i]
            if 0 <= nRow < N and 0 <= nCol < N and _map[nRow][nCol] == 1 and not checked[nRow][nCol]:
                num+=1
                checked[nRow][nCol] = True
                queue.append([nRow, nCol])
    list.append(num)


num = 0

for row in range(N):
    for col in range(N):
        if _map[row][col] == 1 and not checked[row][col]:
            queue.append([row, col])
            checked[row][col] = True
            num += 1
            bfs()

print(num)
list.sort()
for i in list:
    print(i)
