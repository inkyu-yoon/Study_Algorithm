#U : 위쪽으로 한 칸
#D : 아래쪽으로 한 칸
#R : 오른쪽으로 한 칸
#L : 왼쪽으로 한칸
def solution(dirs):
    answer = 0
    _set = set()
    x,y=0,0
    for dir in dirs:
        if dir == 'U':
            dx,dy=0,1
        elif dir == 'D':
            dx,dy=0,-1
        elif dir == 'R':
            dx,dy=1,0
        else:
            dx,dy=-1,0
        nx,ny=x+dx,y+dy
        if -5<=nx<=5 and -5<=ny<=5:
            nx = x+dx
            ny = y+dy
            if not ((x,y,nx,ny) in _set and (nx,ny,x,y) in _set):
                answer+=1
                _set.add((x,y,nx,ny))
                _set.add((nx,ny,x,y))
            x,y = nx,ny
    return answer