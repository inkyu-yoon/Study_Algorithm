import sys

N,M = map(int,input().split())
_map = [[0]*(N+1) for _ in range(N+1)]
ans=[]
for i in range(N):
    info = list(map(int,sys.stdin.readline().split()))
    for j in range(N):
        _map[i+1][j+1]=info[j]

for r in range(1,N+1):
    for c in range(1,N+1):
        _map[r][c] = _map[r][c]+_map[r-1][c]+_map[r][c-1]-_map[r-1][c-1]

for i in range(M):
    x1,y1,x2,y2 = map(int,input().split())
    ans.append(_map[x2][y2]-_map[x1-1][y2]-_map[x2][y1-1]+_map[x1-1][y1-1])

for i in ans:
    print(i)
