import sys
N = int(input())
nums = list(map(int,sys.stdin.readline().split()))
ops = list(map(int,sys.stdin.readline().split()))

stack = []

_max = -1e9
_min = 1e9
def bt():
    global _max
    global _min
    if len(stack) == len(nums)-1:
        _sum = nums[0]
        for i in range(len(stack)):

            if stack[i] == 0:
                _sum+=nums[i+1]
            elif stack[i] == 1:
                _sum-=nums[i+1]
            elif stack[i] ==2 :
                _sum*=nums[i+1]
            else:
                _sum=int(_sum/nums[i+1])
        _max = max(_max,_sum)
        _min = min(_min,_sum)


        return
    for i in range(0,4):
        if ops[i] == 0:
            continue
        stack.append(i)
        ops[i]-=1
        bt()
        stack.pop()
        ops[i]+=1
bt()
print(_max)
print(_min)