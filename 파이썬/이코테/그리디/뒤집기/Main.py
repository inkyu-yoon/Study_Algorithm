import sys

arr = list(map(int,sys.stdin.readline().rstrip()))

key = arr[0]
unit = 1
for num in arr:
    if key!=num:
       unit+=1
       key = num
# unit이 1인 경우 0 // 2,3인경우 답 1 // 4,5인경우 2

print(unit//2)
