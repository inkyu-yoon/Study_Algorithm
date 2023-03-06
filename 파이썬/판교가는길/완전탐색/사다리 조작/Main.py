# 세로선의 갯수 N, 가로선의 갯수 M, 가로선을 놓을 수 있는 위치 H 갯수
# a와 b는 b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미
# i번의 결과가 i번이 나와야 한다.
import sys
N,M,H = map(int,input().split())
ladders = [[0] * N for _ in range(H)]

defaultLadders = [list(map(int,sys.stdin.readline().split())) for _ in range(M)]

for ladder in defaultLadders:
    ladders[ladder[0]-1][ladder[1]-1] = 1
    ladders[ladder[0]-1][ladder[1]] = -1

def isRight():
    for i in range(N):
        location = i
        for j in range(H):
            if ladders[j][location] > 0:
                location += 1
            elif ladders[j][location] <0:
                location -= 1
        if i != location:
            return False
    return True

laddersNum = 0
ans =4
def bt():

    global laddersNum
    global ans

    if isRight():
        ans = min(ans,laddersNum)
        return
    if laddersNum ==3 or laddersNum>ans:
        return
    for i in range(H):
        for j in range(N-1):
            if abs(ladders[i][j]) > 0 or abs(ladders[i][j+1]) > 0:
                continue
            ladders[i][j]=1
            ladders[i][j+1]=-1
            laddersNum +=1
            bt()
            ladders[i][j]=0
            ladders[i][j+1]=0
            laddersNum -= 1
bt()
if ans == 4:
    print(-1)
else:
    print(ans)



