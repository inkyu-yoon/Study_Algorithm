import sys
sys.setrecursionlimit(10**6)
N = int(input())

_map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

maxHeight = max(max(_map))

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def dfs(r, c, height):
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < N and 0 <= nc < N and _map[nr][nc] > height and not checked[nr][nc]:
            checked[nr][nc] = True
            dfs(nr, nc, height)


ans = 0

for height in range(maxHeight):
    area = 0
    checked = [[False] * N for _ in range(N)]
    for r in range(N):
        for c in range(N):
            if not checked[r][c] and _map[r][c] > height:
                checked[r][c] = True
                dfs(r, c, height)
                area += 1
    ans = max(ans, area)

print(ans)
