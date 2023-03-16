from itertools import combinations

N = int(input())
money = list(map(int, input().split()))
money.sort()

s1 = set()

for i in range(1, N + 1):
    c = combinations(money, i)
    for j in c:
        s1.add(sum(j))

target = 1
while True:
    if target not in s1:
        print(target)
        break
    else:
        target += 1

'''
5
3 2 1 1 9
'''
