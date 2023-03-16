
N,M = map(int,input().split())
balls = list(map(int,input().split()))

# 서로 다른 무게의 볼링공을 선택해야함 공의 최대 무게 10
nums = [0]*(11)
for ball in balls:
    nums[ball]+=1

ans = 0

for i in range(1,11):
    if nums[i]!=0:
        ans+=nums[i]*sum(nums[i+1:])

print(ans)

'''
5 3
1 3 2 3 2

8 5
1 5 4 3 2 4 5 2
'''