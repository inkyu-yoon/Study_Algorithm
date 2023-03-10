import sys
N = int(input())
_map = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

_max = 0
for i in range(N):
    info = max(_map[i])
    _max = max(_max,info)
stack = []

dr = [1,-1,0,0]
dc = [0,0,1,-1]

def dfs(rainHeight):
    while stack:
        r,c=stack.pop()
        for i in range(4):
            nr = dr[i]+r
            nc = dc[i]+c
            if 0<=nr<N and 0<=nc<N and not checked[nr][nc] and _map[nr][nc]>=rainHeight:
                stack.append([nr,nc])
                checked[nr][nc]=True

ans = 1

# max 높이 이상 잠기는거 확인 -> ... -> 3이상
for i in range(_max,1,-1):
    num = 0
    checked = [[False]*N for _ in range(N)]
    rainHeight = i
    for r in range(N):
        for c in range(N):
            if _map[r][c] >= rainHeight and not checked[r][c]:
                stack.append([r,c])
                checked[r][c]=True
                dfs(rainHeight)
                num+=1
    ans = max(ans,num)
print(ans)
