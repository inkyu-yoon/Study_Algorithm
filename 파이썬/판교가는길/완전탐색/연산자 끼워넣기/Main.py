import sys
N = int(input())
nums = list(map(int,sys.stdin.readline().split()))
ops = list(map(int,sys.stdin.readline().split()))

stack=[]
_max = -1e9
_min = 1e9
def bt():
    global _max
    global _min
    if len(stack)==N-1:
        sum = nums[0]
        for i in range(len(stack)):
            op = stack[i]
            if op == 0:
                sum+=nums[i+1]
            elif op == 1:
                sum-=nums[i+1]
            elif op == 2:
                sum*=nums[i+1]
            elif op == 3:
                sum=int(sum/nums[i+1])

        _max = max(sum,_max)
        _min = min(sum,_min)

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