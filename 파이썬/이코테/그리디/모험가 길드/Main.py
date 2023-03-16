
N = int(input())
arr = list(map(int,input().split()))

# 여행을 떠날 수 있는 그룹 수의 최대값
# 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 그룹에 들어가야한다.
# 1 2 2 2 3 3
arr.sort()

num = 0
count = 0
for person in arr:
    count+=1
    if person == count:
        num+=1
        count=0

print(num)

'''
5
2 3 1 2 2

2
'''