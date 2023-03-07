import sys

#예제 입력
N,M = map(int,sys.stdin.readline().split())
_map = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

chickens = []
houses = []

# 집과 치킨집 좌표 저장
for row in range(N):
    for col in range(N):
        if _map[row][col] == 2:
            chickens.append([row,col])
        elif _map[row][col] == 1:
            houses.append([row,col])

selected = []
checked = [False]*(len(chickens))
ans = 1e9
def getMinDistance(selected):
    minDistance = 0
    for house in houses:
        houseR = house[0]
        houseC = house[1]
        distance = 1e9
        for storeNum in selected:
            chicken = chickens[storeNum]
            chickenR = chicken[0]
            chickenC = chicken[1]
            distance = min(distance,abs(houseR-chickenR)+abs(houseC-chickenC))
        minDistance +=distance
    return minDistance
def bt():
    global ans
    if len(selected) == M:
        ans = min(ans,getMinDistance(selected))
        return
    for i in range(len(chickens)):
        if checked[i] == True:
            continue
        if len(selected)>=1 and selected[-1] > i:
            continue
        selected.append(i)
        checked[i] = True
        bt()
        selected.pop()
        checked[i] = False
bt()
print(ans)
