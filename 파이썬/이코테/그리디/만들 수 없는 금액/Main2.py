from itertools import combinations

N = int(input())
money = list(map(int, input().split()))
money.sort()

target = 1

for num in money:
    if num>target:
        break
    target+=num
print(target)


'''
5
3 2 1 1 9
'''
