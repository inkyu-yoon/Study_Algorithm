from collections import deque


def solution(maps):
    R = len(maps)
    C = len(maps[0])
    q = deque()

    checked = [[False for _ in range(C)] for _ in range(R)]
    checked[0][0] = True
    q.append([0, 0])

    dr = [1, -1, 0, 0]
    dc = [0, 0, 1, -1]

    def bfs():
        while q:
            r, c = q.popleft()
            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if 0 <= nr < R and 0 <= nc < C and not checked[nr][nc] and maps[nr][nc] == 1:
                    q.append([nr, nc])
                    checked[nr][nc] = True
                    maps[nr][nc] = maps[r][c] + 1

    bfs()

    if maps[-1][-1] == 1:
        return -1
    else:
        return maps[-1][-1]

