import sys

N = int(input())
stat = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

checked = [False] * N

_min = 1e9

