
R,C = map(int,input().split())
_map = [list(map(int,input())) for _ in range(R)]
checked = [[False]*C for _ in range(R)]

stack = []

dr = [1,-1,0,0]
dc = [0,0,1,-1]

def dfs():
    while stack:
        r,c = stack.pop()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0<=nr<R and 0<=nc<C and _map[nr][nc]==0 and not checked[nr][nc]:
                checked[nr][nc]=True
                stack.append([nr,nc])
ans = 0
for i in range(R):
    for j in range(C):
        if _map[i][j]==0 and not checked[i][j]:
            checked[i][j]=True
            stack.append([i,j])
            dfs()
            ans+=1
print(ans)



'''
4 5
00110
00011
11111
00000

3
'''