from collections import deque

mapSize = int(input())

_map = [[0] * mapSize for _ in range(mapSize)]

for i in range(mapSize):
    info = input()
    for j in range(mapSize):
        _map[i][j] = int(info[j])

checked = [[False] * mapSize for _ in range(mapSize)]
queue = deque([])

dr = [1,-1,0,0]
dc = [0,0,1,-1]

village = 0
ans = []

def bfs():
    num = 1
    while len(queue) != 0:
        point = queue.popleft()
        row = point[0]
        col = point[1]
        for i in range(4):
            nRow = row + dr[i]
            nCol = col + dc[i]
            if 0<= nRow < mapSize and 0<= nCol < mapSize and _map[nRow][nCol] == 1 and not checked[nRow][nCol]:
                queue.append([nRow,nCol])
                checked[nRow][nCol]= True
                num+=1
    ans.append(num)


for i in range(mapSize):
    for j in range(mapSize):
        if _map[i][j] == 1 and not checked[i][j]:
            queue.append([i,j])
            checked[i][j]=True
            village+=1
            bfs()

print(village)
ans.sort()
for num in ans:
    print(num)