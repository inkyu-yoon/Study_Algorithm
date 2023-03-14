R, C = map(int, input().split())
r, c, d = map(int, input().split())
_map = [list(map(int, input().split())) for _ in range(R)]

# 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 갈 곳을 정한다. (0 -> 3 -> 2 -> 1 -> 0)
# 왼쪽 방향이 아직 가보지 않은 칸이라면 왼쪽 방향 칸을 전진한다. 없으면 한번더 왼쪽 방향을 본다.
# 방문안한 곳이 없다면 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다.뒤가 바다라면 멈춘다.
# 캐릭터가 방문한 칸의 수를 출력하라
# 0 육지
# 북 동 남 서
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

checked = [[False]*C for _ in range(R)]

checked[r][c]=True
ans = 1
checkNum = 0
while True:
    d = (d+3)%4

    nr = dr[d]+r
    nc = dc[d]+c

    checkNum+=1

    if 0<=nr<R and 0<=nc<C and _map[nr][nc] == 0 and not checked[nr][nc]:
        r = nr
        c = nc
        checked[nr][nc]=True
        ans+=1
        checkNum=0

    if checkNum == 5:
        d = (d+2)%4
        nr = dr[d]+r
        nc = dc[d]+c
        if _map[nr][nc]==1:
            break
        else:
            r = nr
            c = nc
            checkNum = 0

print(ans)





'''
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1

3
'''
