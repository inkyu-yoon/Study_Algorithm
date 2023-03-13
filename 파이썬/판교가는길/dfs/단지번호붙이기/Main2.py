import sys

N = int(input())

_map = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]

checked = [[False]*N for _ in range(N)]

dr = [1,-1,0,0]
dc = [0,0,1,-1]
def dfs(r,c):
    global house
    house+=1
    for i in range(4):
        nr = dr[i]+r
        nc = dc[i]+c
        if 0<=nr<N and 0<=nc<N and not checked[nr][nc] and _map[nr][nc]==1:
            checked[nr][nc]=True
            dfs(nr,nc)


num = 0
_list = []
for r in range(N):
    for c in range(N):
        if _map[r][c]==1 and not checked[r][c]:
            house = 0
            checked[r][c]=True
            dfs(r,c)
            _list.append(house)
            num+=1
print(num)
_list.sort()
for element in _list:
    print(element)