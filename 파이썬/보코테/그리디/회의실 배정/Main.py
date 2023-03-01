# 사용할 수 있는 회의의 최대 개수
import sys

N = int(input())

timeList = [list(map(int,input().split())) for _ in range(N)]
timeList.sort(key = lambda x : (x[1],x[0]))
ans =0
time =0

for i in range(N):
    start,end = timeList[i]
    if(start>=time):
        time = end
        ans+=1
print(ans)