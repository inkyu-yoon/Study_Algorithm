# 0은 빈칸 1은 집 2는 치킨집
# 각각의 집은 치킨 거리를 가지고 있따.
# 임의의 두칸 (r1,c1) (r2,c2)의 거리는 |r1-r2|+|c1-c2|
# 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지는 폐업시키는데 어떻게 고르면 도시의 치킨거리(각 집의 치킨거리의 합)이 최소가 되는가

import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())
_map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

chickens = []
houses = []

for row in range(N):
    for col in range(N):
        if _map[row][col] == 2:
            chickens.append([row, col])
        elif _map[row][col] == 1:
            houses.append([row, col])

stack = []
checked =[False]*(len(chickens)+1)
ans = 1e9
def getDistance(stack):
    _sum=0
    for house in houses:
        dis = 1e9
        houseR = house[0]
        houseC = house[1]
        for i in stack:
            chicken = chickens[i]
            chickenR = chicken[0]
            chickenC = chicken[1]
            dis = min(dis,abs(houseR-chickenR)+abs(houseC-chickenC))
        _sum+=dis
    return _sum

def bt():
    global ans
    if len(stack) == M:
        ans = min(ans,getDistance(stack))
        return
    for i in range(len(chickens)):
        if checked[i]==True:
            continue
        if len(stack)>=1 and stack[-1]>i:
            continue
        stack.append(i)
        checked[i]=True
        bt()
        stack.pop()
        checked[i]=False
bt()
print(ans)
