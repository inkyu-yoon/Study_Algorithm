# 게임은 N * N 정사각 보드 위에서 진행된다.
# 뱀은 맨위 맨 좌측에 위치하고 오른쪽을 향한다. 그리고 뱀의 길이는 1
# 매 초마다 이동을 한다.
# 먼저 몸길이를 늘려 머리를 다음칸에 이동 -> 사과가 있다면 사과가 없어지고 꼬리는 움직이지 않음, 사과가 없다면 꼬리가 위치했던 칸 비워줌
#
from collections import deque

#오른쪽, 아래쪽 , 왼쪽, 위쪽
# D는 오른쪽, L은 왼쪽
# 0에서 D를 받으면 1로  L을 받으면 3으로
# 1에서 D를 받으면 2로 L을 받으면 0으로
# 2에서 D를 받으면 3으로 L을 받으면 1로
# 3에서 D를 받으면 0로 L을 받으면 2로
dx = [1,0,-1,0]
dy = [0,1,0,-1]

def change_direct(command,direction):
    if(command=='D'):
        return (direction+1)%4
    elif(command=='L'):
        return (direction-1)%4


mapSize = int(input())
board = [[0]*mapSize for _ in range(mapSize)]

appleNum = int(input())

# 사과 위치 등록
for _ in range(appleNum):
    row,col = map(int,input().split())
    board[row-1][col-1] = 1

# 명령 큐에 저장
commandNum = int(input())
times = {}

for _ in range(commandNum):
    sec,command = map(str,input().split())
    times[int(sec)]=command

direction = 0
time = 1
y,x=0,0
snake = deque([])

snake.append([y, x])
board[y][x]=2

while True:
    y = y + dx[direction]
    x = x + dy[direction]
    if 0<= y <mapSize and 0<= x < mapSize and board[y][x]!=2:
        #이동한 위치에 사과가 없을 때
        if(board[y][x]!=1):
            tailX,tailY = snake.popleft()
            print("tailX",tailX)
            print("tailY",tailY)
            board[tailX][tailY] = 0
        # 머리 이동
        board[y][x] = 2
        snake.append([y, x])
        if time in times:
            direction = change_direct(times[time],direction)
        time+=1
    else:
        break
print(time)




