import sys

N = int(input())
_map = [[0]*N for _ in range(N)]

for r in range(N):
    info = input()
    for c in range(N):
        _map[r][c]=int(info[c])




checked = [[False] * N for _ in range(N)]


stack = []


def dfs():
    num = 1
    while stack:
        r,c=stack.pop()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0<=nr<N and 0<=nc<N and _map[nr][nc] ==1 and not checked[nr][nc]:
                _map[nr][nc]=0
                stack.append([nr,nc])
                checked[nr][nc]=True
                num+=1
    return num


dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

ans = 0
nums = []
for r in range(N):
    for c in range(N):
        if _map[r][c] == 1:
            stack.append([r, c])
            checked[r][c] = True
            nums.append(dfs())

            ans+=1
print(ans)
nums.sort()
for num in nums:
    print(num)