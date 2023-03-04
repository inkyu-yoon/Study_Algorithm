import sys

N = int(input())

board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

stack = []
checked = [False] * (N + 1)

ans = 1e9


def bt():
    global ans

    if len(stack) == N // 2:
        startScore = 0
        linkScore = 0
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if checked[i] and checked[j] and i < j:
                    startScore += board[i - 1][j - 1] + board[j - 1][i - 1]
                if not checked[i] and not checked[j] and i < j:
                    linkScore += board[i - 1][j - 1] + board[j - 1][i - 1]
        ans = min(abs(startScore - linkScore), ans)

        return

    for i in range(1, N + 1):
        if checked[i] == True:
            continue
        if len(stack) >= 1 and stack[-1] > i:
            continue

        stack.append(i)
        checked[i] = True
        bt()
        stack.pop()
        checked[i] = False


bt()
print(ans)
