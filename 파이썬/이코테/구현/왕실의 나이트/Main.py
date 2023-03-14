info = input()

r = (int)(info[1]) -1
c = ord(info[0]) - ord('a')

dr = [-1,-1,-2,-2,1,1,2,2]
dc = [-2,2,-1,1,-2,2,-1,1]

ans = 0

for i in range(8):
    nr = dr[i]+r
    nc = dc[i]+c
    if 0<=nr<8 and 0<=nc<8:
        ans+=1
print(ans)