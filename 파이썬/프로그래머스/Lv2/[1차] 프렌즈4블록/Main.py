def solution(m, n, board):
    answer = 0
    # 맵 생성
    for i in range(len(board)):
        board[i] = list(board[i])

    dr = [1, 1, 0]
    dc = [0, 1, 1]

    def check(r, c):
        text = board[r][c]
        if text == '0':
            return False

        for i in range(3):
            nr, nc = r + dr[i], c + dc[i]
            if text != board[nr][nc]:
                break
        else:
            return True
        return False

    while True:
        _set = set()
        for r in range(m - 1):
            for c in range(n - 1):
                if check(r, c):
                    _set.add((r, c))
                    for i in range(3):
                        _set.add((r + dr[i], c + dc[i]))
        if len(_set) == 0:
            break
        answer += len(_set)
        for point in _set:
            board[point[0]][point[1]] = '0'

        for c in range(n):
            zero = 0
            start = False
            for r in range(m - 1, -1, -1):
                if board[r][c] == '0':
                    zero += 1
                    start = True
                else:
                    if start:
                        board[r + zero][c] = board[r][c]
                        board[r][c] = '0'

    return answer