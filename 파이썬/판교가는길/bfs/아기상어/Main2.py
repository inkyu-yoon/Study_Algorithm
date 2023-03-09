import sys
import copy
from collections import deque

# 예제 입력
N = int(input())
_map = [[0]*N for _ in range(N)]
checked = [[False]*N for _ in range(N)]
queue = deque([])


for i in range(N):
    info = list(map(int,sys.stdin.readline().split()))
    for j in range(N):
        _map[i][j]=info[j]
        if info[j] == 9:
            _map[i][j] = 0
            shark = [i,j,0]
            queue.append(shark)


# bfs()로 먹을 수 있는 먹이 탐색하기

dr = [1,-1,0,0]
dc = [0,0,1,-1]

fish = []
def bfs(sharkSize):
    copiedMap = copy.deepcopy(_map)
    copiedCheck = copy.deepcopy(checked)
    while len(queue) !=0:
        r,c,t = map(int,queue.popleft())
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            nt = t + 1
            if 0<=nr<N and 0<=nc<N and copiedMap[nr][nc]<=sharkSize and not copiedCheck[nr][nc]:

                queue.append([nr,nc,nt])
                copiedCheck[nr][nc]=True

                if 0< copiedMap[nr][nc] <sharkSize:
                    fish.append([nr,nc,nt])
    if fish:
        fish.sort(key = lambda x : (x[2],x[0],x[1]))
        return fish[0]
    else:
        return None

sharkSize = 2
food = 0
ans = 0
while True:
    fish.clear()
    result = bfs(sharkSize)
    if result:
        r,c,t = map(int,result)
        food +=1
        if sharkSize == food:
            sharkSize+=1
            food = 0
        _map[r][c]=0
        queue.append([r,c,0])
        ans+=t
    else:
        break
print(ans)

