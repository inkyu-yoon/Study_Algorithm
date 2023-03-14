import sys

R, C = map(int, input().split())
board = [list(sys.stdin.readline().rstrip()) for _ in range(R)]

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
checked =set()

ans = 0


def dfs(r, c, d):
    global ans

    checked.add(board[r][c])

    ans = max(ans, d)
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < R and 0 <= nc < C and board[nr][nc] not in checked:
            dfs(nr, nc, d + 1)

    checked.remove(board[r][c])

dfs(0,0,1)

print(ans)