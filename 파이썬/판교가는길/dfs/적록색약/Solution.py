import sys

## 적록색약인 사람은 빨강과 초록 (R-G)이 붙어있으면 하나로본다.

N = int(input())
_map = [list(sys.stdin.readline().rstrip()) for _ in range(N)]
stack = []
ans = 0
checked = [[False] * N for _ in range(N)]

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def dfs():
    while stack:
        r, c = stack.pop()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N and not checked[nr][nc] and _map[nr][nc] == _map[r][c]:
                stack.append([nr, nc])
                checked[nr][nc] = True


def dfs2():
    while stack:
        r, c = stack.pop()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N and not checked[nr][nc]:
                if _map[nr][nc] == _map[r][c]:
                    stack.append([nr, nc])
                    checked[nr][nc] = True
                if (_map[r][c] == 'R' and _map[nr][nc] == 'G') or (_map[r][c] == 'G' and _map[nr][nc] == 'R'):
                    stack.append([nr, nc])
                    checked[nr][nc] = True


for r in range(N):
    for c in range(N):
        if not checked[r][c]:
            stack.append([r, c])
            checked[r][c] = True
            dfs()
            ans += 1

checked = [[False] * N for _ in range(N)]
ans2 = 0

for r in range(N):
    for c in range(N):
        if not checked[r][c]:
            stack.append([r, c])
            checked[r][c] = True
            dfs2()
            ans2 += 1

print(ans, ans2)
