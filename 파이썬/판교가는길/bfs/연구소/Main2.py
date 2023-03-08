import copy
import sys
from collections import deque

# 예제 입력
row,col= map(int,input().split())
_map = [[0]*col for _ in range(row)]

for i in range(row):
    info = list(map(int,sys.stdin.readline().split()))
    for j in range(col):
        _map[i][j]=info[j]

queue = deque([])

# 바이러스 위치 저장
for i in range(row):
    for j in range(col):
        if _map[i][j] == 2:
            queue.append([i,j])

dr = [1,-1,0,0]
dc = [0,0,1,-1]

ans = -1e9

def getSafeArea(copiedMap):
    num = 0
    for i in range(row):
        num+=copiedMap[i].count(0)
    return num

# 바이러스 퍼트리기 bfs()
def bfs():
    virus = copy.deepcopy(queue)
    copiedMap = copy.deepcopy(_map)
    while len(virus) !=0:
        r,c = virus.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0<=nr<row and 0<=nc<col and copiedMap[nr][nc]==0:
                virus.append([nr,nc])
                copiedMap[nr][nc]=2
    return getSafeArea(copiedMap)
# 벽 3개를 세워보기
def bt(num):
    global ans
    if num == 3:
        ans = max(ans,bfs())
        return
    for i in range(row):
        for j in range(col):
            if _map[i][j] !=0:
                continue
            _map[i][j]=1
            bt(num+1)
            _map[i][j]=0
bt(0)
print(ans)