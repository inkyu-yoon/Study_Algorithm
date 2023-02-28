# 뱀 문제 다시 풀기
from collections import deque

boardSize = int(input())
appleNum = int(input())

# 맵 생성
board = [[0]*boardSize for _ in range(boardSize)]

# 사과 위치 저장 (1로 표시)
for _ in range(appleNum):
    row,col=map(int,input().split())
    board[row-1][col-1] = 1

# 명령 저장 (key : value 로)
commands = {}
commandNum = int(input())

for _ in range(commandNum):
    sec,command = map(str,input().split())
    commands[int(sec)]=command

# direction이 0 인 경우 아래쪽
# 1인 경우 오른쪽
# 2인 경우 위쪽
# 3인 왼쪽
dRow = [-1,0,1,0]
dCol = [0,1,0,-1]

# 초기 방향 1, 초기 시간 0, 초기 위치 (0,0), 뱀 위치는 2로 표시
direction = 1
time = 1
row,col = 0,0
snake = deque([])
snake.append([row,col])
board[row][col] = 2

def change_direction(command,direction):
    # D는 오른쪽으로 방향 변경
    if(command == 'D'):
        return (direction+1)%4
    elif(command == 'L'):
        return (direction-1)%4

## 진행
while True:
    row = dRow[direction] + row
    col = dCol[direction] + col
    # 게임이 끝나지 않는 조건
    if 0<= row < boardSize and 0<= col < boardSize and board[row][col] != 2:
        #사과 없으면 꼬리 제거하고 0으로 초기화
        if board[row][col] != 1:
            tailRow,tailCol=snake.popleft()
            board[tailRow][tailCol]=0
        # 다음 위치 2로 바꾸고 큐에 추가
        board[row][col] = 2
        snake.append([row,col])

        if time in commands:
            direction = change_direction(commands[time],direction)
        time+=1
    else:
        break
print(time)
