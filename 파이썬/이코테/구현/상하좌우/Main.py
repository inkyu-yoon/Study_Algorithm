
N = int(input())
commands = list(input().split())

point = [1, 1]

for cmd in commands:
    r = point[0]
    c = point[1]

    if cmd == 'R':
        resultR = r
        resultC = c+1
    elif cmd == 'L':
        resultR = r
        resultC = c -1
    elif cmd == 'U':
        resultR = r - 1
        resultC = c
    elif cmd == 'D':
        resultR = r +1
        resultC = c

    if not (resultR ==0 or resultR >N or resultC==0 or resultC>N):
        point = [resultR, resultC]

print(*point)

'''
5
R R R U D D

3 4
'''