from collections import deque

R,C = map(int,input().split())
_map = [list(map(int,input())) for _ in range(R)]
checked=[[False]*C for _ in range(R)]

queue = deque([])

dr = [1,-1,0,0]
dc = [0,0,1,-1]
def bfs():
    while queue:
        r,c,d = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0<=nr<R and 0<=nc<C and _map[nr][nc]==1 and not checked[nr][nc]:
                queue.append([nr,nc,d+1])
                checked[nr][nc]=True
                if nr == R-1 and nc == C-1:
                    print(d+1)
                    break

queue.append([0,0,1])
bfs()





'''
5 6
101010
111111
000001
111111
111111

10
'''